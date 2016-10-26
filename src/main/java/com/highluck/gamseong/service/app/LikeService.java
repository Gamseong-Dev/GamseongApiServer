package com.highluck.gamseong.service.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.common.annotation.SuccessHigh;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.LikeValue;
import com.highluck.gamseong.repository.LikeRepository;

@Service
public class LikeService {

	@Autowired
	private LikeRepository likeRepository;
	@Autowired
	private CommonResponse commonResponse;
	
	//@SuccessHigh
	@Transactional(readOnly = false)
	public CommonResponse setLike(LikeValue value){
		
		likeRepository.addLike(value);		
		likeRepository.setLike(value);
		commonResponse.setResult(commonResponse.SUCCESS);
		
		return commonResponse;
	}
}
