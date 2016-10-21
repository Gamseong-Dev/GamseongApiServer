package com.highluck.gamseong.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.domain.Reply;
import com.highluck.gamseong.model.value.FeedValue;

@Repository
public class ReplyRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<?> findByFeedId(FeedValue value){
		
		String query = "SELECT r "
				+ " FROM REPLY r "
				+ " JOIN FETCH r.user "
				+ " WHERE r.feedId = :feedId ";
		
		return entityManager.createQuery(query)
				 .setParameter("feedId",value.getId())
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
}
