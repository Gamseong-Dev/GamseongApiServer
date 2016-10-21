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
				+ " OR f.location.motherId = :locationId "
				+ " ORDER BY f.creationTime DESC";
		
		return entityManager.createQuery(query)
					 .setParameter("locationId",value.getLocationId())	
					 .setFirstResult(value.getOffset())
				     .setMaxResults(value.getLimit()) 
					 .getResultList();	
	}

	public Feed findById(FeedValue value){
		
		String query = "SELECT f "
				+ " FROM FEED f "
				+ " JOIN FETCH f.user "
				+ " JOIN FETCH f.location "
				+ " WHERE f.id = :id ";
		
		return (Feed) entityManager.createQuery(query)
				 .setParameter("id",value.getId())
				 .getSingleResult();
	}
	
	public void save(Feed feed){
		
		feed.setCreationTime(Timestamp.valueOf(LocalDateTime.now()));
		entityManager.persist(feed);		
  	}
	
	public void addLike(FeedValue value){
		
		String query = 
				"UPDATE FEED"
				+ " SET likeCount = likeCount + 1"
				+ " WHERE id = :id";
		
		entityManager.createQuery(query)
					.setParameter("id", value.getId());
			
	}
	/*
	 * .setFirstResult(offset) // offset
     * .setMaxResults(limit) // limit
     * .getResultList();
	 */
}
