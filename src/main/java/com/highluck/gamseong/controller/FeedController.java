package com.highluck.gamseong.controller;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highluck.gamseong.common.annotation.HighAuth;
import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.response.FeedResponse;
import com.highluck.gamseong.model.value.FeedPostValue;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.service.app.FeedService;

@RestController
@RequestMapping("/feeds")
public class FeedController {

	@Autowired
	private FeedService feedService;
	
	//@HighAuth
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String test(){
		
		return "testgoood";
	}
	
	@RequestMapping(value ="", method = RequestMethod.POST)
	public Callable<CommonResponse> save(@RequestBody FeedPostValue value, HttpServletRequest request){
		
		return () -> {
			value.setPath(request.getSession().getServletContext().getRealPath("/"));	
			return feedService.save(value);	
		};
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public Callable<FeedResponse> findById(@ModelAttribute FeedValue value){
		
		return () -> {	
			return feedService.findById(value);	
		};
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.PUT)
	public CommonResponse set(@RequestBody Feed feed){
		
		return feedService.set(feed);
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public CommonResponse delete(@PathVariable long id){
		
		return feedService.delete(id);	
	}
	
	@RequestMapping(value ="/locations/{locationId}", method = RequestMethod.GET)
	public Callable<ArrayList<FeedResponse>> findAllByLocationId(@ModelAttribute FeedValue value){
		
		return () -> {	
			return  feedService.findAllByLocationId(value);
		};
	}
	
	@RequestMapping(value ="/best", method = RequestMethod.GET)
	public Callable<ArrayList<FeedResponse>> findBest(@ModelAttribute FeedValue value){
		
		return () -> {	
			return feedService.findBest(value);	
		};
	}
}
