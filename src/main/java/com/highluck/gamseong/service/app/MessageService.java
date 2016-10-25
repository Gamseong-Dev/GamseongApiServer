package com.highluck.gamseong.service.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highluck.gamseong.model.domain.Message;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.MessageValue;
import com.highluck.gamseong.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;

	public CommonResponse save(Message message){
		
		CommonResponse response = new CommonResponse();
		messageRepository.save(message);
		response.setResult(response.SUCCESS);
		
		return response;
	}
	
	public ArrayList<Message> findAllByReciveUserId(MessageValue value){
		
		return messageRepository.findAllByReciveUserIdAndStatus(value);
	}
	
	public ArrayList<Message> findAllBySendUserId(MessageValue value){
		
		return messageRepository.findAllBySendUserIdAndStatus(value);
	}
	
	public Message findById(int id){
		
		return messageRepository.findById(id);
	}
}
