package com.highluck.gamseong.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.Message;
import com.highluck.gamseong.model.value.MessageValue;
import com.highluck.gamseong.repository.interfaces.MessageInterface;

@Repository
public class MessageRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private MessageInterface messageInterface;
	
	public void save(Message message){
		
		message.setSendTime(Timestamp.valueOf(LocalDateTime.now()));
		message.setStatus("Y");
		entityManager.persist(message);
		entityManager.flush();
	}
	
	public ArrayList<Message> findAllByReciveUserIdAndStatus(MessageValue value){
		return messageInterface.findAllByReciveUserIdAndStatusOrderBySendTime(value.getReciveUserId(), "Y");
	}
	
	public ArrayList<Message> findAllBySendUserIdAndStatus(MessageValue value){
		return messageInterface.findAllBySendUserIdAndStatusOrderBySendTime(value.getSendUserId(), "Y");
	}
	
	public Message findById(int id){
		return messageInterface.findById(id);
	}
	
}
