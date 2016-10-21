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
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.service.app.FeedService;

@RestController
@RequestMapping("/feed")
public class FeedController {

	@Autowired
	private FeedService feedService;
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String test(){
		
		return "testgoood";
	}
	
	@RequestMapping(value ="/", method = RequestMethod.POST)
	public  Callable<CommonResponse> save(@RequestBody Feed feed){
		
		return () -> {
			return feedService.save(feed);	
		};
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public Callable<Feed> findById(@ModelAttribute FeedValue value){
		
		return () -> {	
			return feedService.findById(value);	
		};
	}

	@RequestMapping(value ="/{id}/like", method = RequestMethod.GET)
	public  Callable<CommonResponse> addLike(@ModelAttribute FeedValue value){
		
		return () -> {
			return feedService.addLike(value);	
		};
	}
	
	@RequestMapping(value ="/location/{locationId}", method = RequestMethod.GET)
	public Callable<ArrayList<Feed>> findAllByLocationId(@ModelAttribute FeedValue value){
		
		return () -> {	
			return feedService.findAllByLocationId(value);	
		};
	}
}
