package com.highluck.gamseong.service.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.model.domain.Message;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.MessageValue;
import com.highluck.gamseong.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private CommonResponse commonResponse;

	@Transactional(readOnly = false)
	public CommonResponse save(Message message){
		
		messageRepository.save(message);
		commonResponse.setResult(commonResponse.SUCCESS);
		
		return commonResponse;
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Message> findAllByReciveUserId(MessageValue value){
		
		return messageRepository.findAllByReciveUserIdAndStatus(value);
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Message> findAllBySendUserId(MessageValue value){
		
		return messageRepository.findAllBySendUserIdAndStatus(value);
	}
	
	@Transactional(readOnly = true)
	public Message findById(int id){
		
		return messageRepository.findById(id);
	}
}
