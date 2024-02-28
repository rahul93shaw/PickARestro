package com.pickarestro.service;

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

}
