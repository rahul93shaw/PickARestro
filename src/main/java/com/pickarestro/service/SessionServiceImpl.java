package com.pickarestro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickarestro.dto.SessionDto;
import com.pickarestro.model.Session;
import com.pickarestro.repository.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public SessionDto createSession(SessionDto sessionDto) {
		Session newSession = new Session();
		if (!Objects.isNull(sessionDto)) {
			newSession.setSessionType(sessionDto.getSessionType());
			newSession.setSessionDesc(!Objects.isNull(sessionDto.getSessionDesc()) ? sessionDto.getSessionDesc() : "");
			newSession.setCreatedBy(sessionDto.getHost());
			newSession.setCreatedDatetime(sessionDto.getStartDatetime());
			newSession = sessionRepository.save(newSession);
			if(!Objects.isNull(newSession.getSessionId())) {
				sessionDto.setSessionId(newSession.getSessionId());
			}
		}
		return sessionDto;
	}

	@Override
	public List<SessionDto> allActiveSessionsByUser(String username) {
		List<Session> sessions = sessionRepository.findByCreatedBy(username);
		if(!Objects.isNull(sessions)) {
			List<SessionDto> sessionDtos = new ArrayList<>();
			sessions.forEach(ses -> {
				SessionDto sesDto = new SessionDto();
				if(Objects.isNull(ses.getEndDatetime())) {
					sesDto.setHost(username);
					sesDto.setSessionDesc(ses.getSessionDesc());
					sesDto.setSessionType(ses.getSessionType());
					sesDto.setSessionId(ses.getSessionId());
					sessionDtos.add(sesDto);
				}
				
			});
			return sessionDtos;
		} else {
			return null;
		}
	}

}
