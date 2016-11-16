package com.highluck.gamseong.repository.interfaces;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.LikeInfo;
import com.highluck.gamseong.model.domain.Message;

@Repository
public interface MessageInterface extends CrudRepository<Message, Long>{

	ArrayList<Message> findAllBySendUserIdAndStatusOrderBySendTime(String sendUserId, String status);
	
	ArrayList<Message> findAllByReciveUserIdAndStatusOrderBySendTime(String status, String reciveUserId);
	
	Message findById(long id);
}
