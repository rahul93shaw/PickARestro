package com.pickarestro.service;

import com.pickarestro.dao.SessionUserEntity;
import com.pickarestro.dto.SessionDto;
import com.pickarestro.exception.InvalidRequestException;
import com.pickarestro.exception.ResourceNotFoundException;
import com.pickarestro.mapper.RestaurantMapper;
import com.pickarestro.mapper.SessionMapper;
import com.pickarestro.mapper.SessionRestaurantMapper;
import com.pickarestro.mapper.SessionUserMapper;
import com.pickarestro.model.InviteStatus;
import com.pickarestro.repository.RestaurantRepository;
import com.pickarestro.repository.SessionRepository;
import com.pickarestro.repository.SessionRestaurantRepository;
import com.pickarestro.repository.SessionUserRepository;
import com.pickarestro.util.Utility;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {
	
	private static Logger log = LoggerFactory.getLogger(SessionService.class);

    @Autowired
    private SessionRepository sessionRepo;

    @Autowired
    private SessionMapper sessionMapper;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private SessionUserMapper sessionUserMapper;

    @Autowired
    private SessionRestaurantMapper sessionRestaurantMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private SessionUserRepository sessionUserRepo;
    @Autowired
    private SessionRestaurantRepository sessionRestaurantRepo;

    @Autowired
    private RestaurantRepository restaurantRepo;

    public List<SessionDto> getActiveSessions() {
        log.info("getActiveSessions");
        return sessionMapper.map(sessionRepo.findByActive(true));
    }

    public List<SessionDto> getAllSessions() {
        log.info("getAllSessions");
        return sessionMapper.map(sessionRepo.findAll());
    }

    public SessionDto getSession(Long id) {
        log.info("getSession : {}", id);
        var session = sessionMapper.map(sessionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Session not found")));
        var users = sessionUserRepo.findAllBySessionId(session.getId());
        session.setSessionUsers(sessionUserMapper.map(users));
        var restaurants = sessionRestaurantRepo.findAllBySessionId(session.getId());
        session.setSessionRestaurant(sessionRestaurantMapper.map(restaurants));
        return session;
    }

    public SessionDto createSession(SessionDto req) {
        log.info("createSession : {}", req.getName());
        return sessionMapper.map(sessionRepo.save(sessionMapper.mapForCreate(req)));
    }

    public SessionDto updateSession(SessionDto req) {
        log.info("updateSession : {}", req.getId());
        var sessionInDb = sessionRepo.findById(req.getId()).orElseThrow(() -> new ResourceNotFoundException("Session not found"));
        sessionMapper.mapForUpdate(sessionInDb, req);
        return sessionMapper.map(sessionRepo.save(sessionInDb));
    }

    public void deleteSession(Long id) {
        log.info("deleteSession : {}", id);
        var sessionInDb = sessionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Session not found"));
        sessionRepo.delete(sessionInDb);
    }

    public SessionDto invite(Long sessionId, List<Long> userIds) {
        log.info("invite : sessionId {}, userIds {}", sessionId, userIds);
        var sessionUsers = userIds.stream()
                .map(userId -> new SessionUserEntity(sessionId, userId, InviteStatus.invited))
                .collect(Collectors.toList());
        sessionUserRepo.saveAll(sessionUsers);
        return getSession(sessionId);
    }

    public SessionDto join(Long sessionId, Long userId) {
        log.info("join : sessionId {}, userId {}", sessionId, userId);
        var invite = sessionUserRepo.findBySessionIdAndUserId(sessionId, userId).orElseThrow(() -> new ResourceNotFoundException("User not invited for the session"));
        if (InviteStatus.joined.equals(invite.getStatus())) {
            throw new InvalidRequestException("User already joined");
        }
        invite.setStatus(InviteStatus.joined);
        var joined = sessionUserRepo.save(invite);
        log.info("Users joined: {}", joined.getJoinedAt());
        return getSession(sessionId);
    }

    public SessionDto endSession(Long sessionId, Long requesterId) {
        log.info("endSession : sessionId {}", sessionId);
        var session = sessionRepo.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session not found"));
        if (!session.getInitiatedBy().getId().equals(requesterId)) {
            throw new InvalidRequestException("User not allowed to ent this session");
        }
        var sessionRestaurants = sessionRestaurantRepo.findAllBySessionId(session.getId());
        int randomIndex = Utility.generateRandomInt(0, sessionRestaurants.size() - 1);
        session.setPickedRestaurantId(sessionRestaurants.get(randomIndex).getRestaurant().getId());
        session.setActive(false);
        sessionRepo.save(session);
        log.info("Session end");
        return getSession(sessionId);
    }
}
