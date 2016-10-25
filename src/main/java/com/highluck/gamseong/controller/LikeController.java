package com.highluck.gamseong.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.LikeValue;
import com.highluck.gamseong.service.app.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {

	@Autowired
	private LikeService likeService;
	
	@RequestMapping(value="/feed/{feedId}/user/{userId}", method = RequestMethod.GET)
	public Callable<CommonResponse> setLike(@ModelAttribute LikeValue value){
		
		return () -> {
			return likeService.setLike(value);
		};
	}
}
