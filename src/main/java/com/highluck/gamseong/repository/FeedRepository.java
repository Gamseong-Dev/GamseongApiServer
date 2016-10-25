package com.highluck.gamseong.repository;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.value.FeedValue;

@Repository
public class FeedRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<?> findAllByLocationId(FeedValue value){
		
		String query = 
				"SELECT f "
				+ " FROM FEED f "
				+ " JOIN FETCH f.user "
				+ " JOIN FETCH f.location "				
				+ " WHERE f.location.id = :locationId "
					+ " OR f.location.motherId = :locationId"
					+ " AND f.statusCode =  :status"
				+ " ORDER BY f.creationTime DESC";
			
		
		return entityManager.createQuery(query)
					 .setParameter("locationId",value.getLocationId())	
					 .setParameter("status", "Y")
					 .setFirstResult(value.getOffset())
				     .setMaxResults(value.getLimit()) 
					 .getResultList();	
	}

	public Feed findById(FeedValue value){
		
		String query = 
				"SELECT f "
				+ " FROM FEED f "
				+ " JOIN FETCH f.user "
				+ " JOIN FETCH f.location "
				+ " WHERE f.id = :id "
					+ " AND f.statusCode =  :status";
		
		return (Feed) entityManager.createQuery(query)
				 .setParameter("id",value.getId())
				 .setParameter("status", "Y")
				 .getSingleResult();
	}
	
	public void save(Feed feed){
		
		feed.setCreationTime(Timestamp.valueOf(LocalDateTime.now()));
		feed.setStatusCode("Y");
		entityManager.persist(feed);
		feed.getSticker().forEach(s -> {
			s.setFeedId(feed.getId());
		});
		entityManager.flush();
  	}
	
	public void addLike(FeedValue value){
		
		String query = 
				"UPDATE FEED"
				+ " SET likeCount = likeCount + 1"
				+ " WHERE id = :id";
		
		entityManager.createQuery(query)
					.setParameter("id", value.getId());
			
	}
	
	public List<Feed> findBest(FeedValue value){
		
		String query = 
				"SELECT f "
				+ " FROM FEED f "
				+ " JOIN FETCH f.user "
				+ " JOIN FETCH f.location "	
				+ " WHERE f.creationTime >= :fromTime"
				+ " AND f.creationTime <= :toTime"
				+ " AND f.statusCode =  :status"
				+ " ORDER BY f.likeCount DESC";
		
		return  entityManager.createQuery(query)
				 .setParameter("fromTime",value.getFromTime())	
				 .setParameter("toTime",value.getToTime())	
				 .setParameter("status", "Y")
			     .setMaxResults(value.getLimit()) 
				 .getResultList();
	}
	/*
	 * .setFirstResult(offset) // offset
     * .setMaxResults(limit) // limit
     * .getResultList();
	 */
}
