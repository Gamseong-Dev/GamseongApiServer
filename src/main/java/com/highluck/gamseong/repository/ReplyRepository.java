package com.highluck.gamseong.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.domain.Reply;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.repository.interfaces.ReplyInterface;

@Repository
public class ReplyRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private ReplyInterface replyInterface;
	
	public List<?> findByFeedId(long feedId){
		
		String query = "SELECT r "
				+ " FROM REPLY r "
				+ " JOIN FETCH r.user "
				+ " WHERE r.feedId = :feedId ";
		
		return entityManager.createQuery(query)
				 .setParameter("feedId",feedId)
				 .setMaxResults(1) 
				 .getResultList();
	}
	
	public List<?> findAllByFeedId(FeedValue value){
		
		String query = "SELECT r "
				+ " FROM REPLY r "
				+ " JOIN FETCH r.user "
				+ " WHERE r.feedId = :feedId ";
		
		return entityManager.createQuery(query)
				 .setParameter("feedId",value.getId())
				 .setFirstResult(value.getOffset())
			     .setMaxResults(value.getLimit()) 
				 .getResultList();	
	}
	
	public void save(Reply reply){
		
		reply.setCreationTime(Timestamp.valueOf(LocalDateTime.now()));
		reply.setStatusCode("Y");
		entityManager.persist(reply);
		entityManager.flush();
	}
	
	public void set(Reply value){
		
		Reply reply = replyInterface.findById(value.getId());
		reply.setContents(value.getContents());
	}
	
	public void delete(long id){
		
		Reply reply = replyInterface.findById(id);
		reply.setStatusCode("N");
	}
}
