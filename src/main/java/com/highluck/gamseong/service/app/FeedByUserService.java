package com.highluck.gamseong.service.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.model.value.UserValue;
import com.highluck.gamseong.repository.FeedByUserRepository;

@Service
public class FeedByUserService {
	
	@Autowired
	private FeedByUserRepository userRepository;
	private CommonResponse response;
	
	@Transactional(readOnly = true)
	public ArrayList<Feed>findFeedAllByUser(UserValue value){
		
		//if(userRepository.authByToken(value) < 1) return null;
		if(value.getLimit() == 0) value.setLimit(FeedValue.DEFAULT_LIMIT);
		
		return (ArrayList<Feed>) userRepository.findAllByUserId(value);	
	}
	
}
