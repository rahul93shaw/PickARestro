package com.pickarestro.service;

import java.util.List;

import com.pickarestro.dto.SessionDto;

public interface SessionService {
	
	public SessionDto createSession(SessionDto sessionDto);

	public List<SessionDto> allActiveSessionsByUser(String username);
}
