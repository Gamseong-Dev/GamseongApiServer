package com.highluck.gamseong.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.domain.LikeInfo;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.model.value.LikeValue;
import com.highluck.gamseong.repository.interfaces.FeedInterface;
import com.highluck.gamseong.repository.interfaces.LikeInterface;

@Repository
public class LikeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private LikeInterface likeInterface;
	@Autowired
	private FeedInterface feedInterface;
	
	public void setLike(LikeValue value){
		
		LikeInfo like = likeInterface.findByFeedIdAndUserId(value.getFeedId(), value.getUserId());
		
		if(like == null){
			like = new LikeInfo();
			like.setFeedId(value.getFeedId());
			like.setUserId(value.getUserId());
			like.setStatus("Y");	
			entityManager.persist(like);
		}
		else if(like.getStatus().equals("N")) like.setStatus("Y");	
		else like.setStatus("N");
		
	}
	
	public void addLike(LikeValue value){
		
		Feed feed = feedInterface.findById(value.getFeedId());
		feed.setLikeCount(findCountByFeedId(value.getFeedId()));
	}
	
	public long findCountByUserId(String userId, long feedId){
		
		String query = 
				"SELECT COUNT(l)"
				+ " FROM LIKE_INFO l"
				+ " WHERE l.userId = :userId "
				+ " AND l.feedId = :feedId "
				+ " AND l.status = :status ";
		
		return (long) entityManager.createQuery(query)
					.setParameter("feedId", feedId)
					.setParameter("userId", userId)
					.setParameter("status", "Y")
					.getSingleResult();
					
	}
	
	public long findCountByFeedId(long feedId){
		
		String query = 
				"SELECT COUNT(l)"
				+ " FROM LIKE_INFO l"
				+ " WHERE l.feedId = :feedId "
				+ " AND l.status = :status ";
		
		return (long) entityManager.createQuery(query)
					.setParameter("feedId", feedId)
					.setParameter("status", "Y")
					.getSingleResult();
	}
}
