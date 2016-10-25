package com.highluck.gamseong.controller;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highluck.gamseong.model.domain.Reply;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.response.FeedResponse;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.service.app.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value ="/feeds/{id}", method = RequestMethod.GET)
	public Callable<ArrayList<Reply>> findAllByFeedId(@ModelAttribute FeedValue value){
		
		return () -> {	
			return replyService.findAllByFeedId(value);	
		};
	}
	
	@RequestMapping(value ="", method = RequestMethod.POST)
	public CommonResponse save(@RequestBody Reply reply){
		
		return replyService.save(reply);	
	}
	
}
