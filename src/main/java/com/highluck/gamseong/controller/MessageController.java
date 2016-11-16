package com.highluck.gamseong.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highluck.gamseong.model.domain.Message;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.MessageValue;
import com.highluck.gamseong.service.app.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value ="", method = RequestMethod.POST)
	public CommonResponse save(@RequestBody Message message){
		return messageService.save(message);
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public Message findById(@PathVariable("id") int id){
		return messageService.findById(id);
	}
	
	@RequestMapping(value ="/send/users/{sendUserId}", method = RequestMethod.GET)
	public ArrayList<Message> findAllBySendUserId(@ModelAttribute MessageValue value){
		return messageService.findAllBySendUserId(value);
	}
	
	@RequestMapping(value ="/recive/users/{reciveUserId}", method = RequestMethod.GET)
	public ArrayList<Message> findAllByReciveUserId(@ModelAttribute MessageValue value){
		return messageService.findAllByReciveUserId(value);
	}
}
