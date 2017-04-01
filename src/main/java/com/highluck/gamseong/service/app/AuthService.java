package com.highluck.gamseong.service.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.model.value.AuthValue;
import com.highluck.gamseong.repository.AuthRepository;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;
	
	@Async
	@Transactional(readOnly=true)
	public long authByToken(final AuthValue value){
		return authRepository.authByToken(value);
	}
}
