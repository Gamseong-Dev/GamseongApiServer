package com.highluck.gamseong.controller;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.value.UserValue;
import com.highluck.gamseong.service.app.FeedByUserService;

@RestController
@RequestMapping("/feed/user")
public class FeedByUserController {
	
	@Autowired
	private FeedByUserService userService;
	
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public Callable<ArrayList<Feed>>findFeedAllByUser(@ModelAttribute UserValue value){
		
		return () -> {
			return userService.findFeedAllByUser(value);
		};
	}

}
