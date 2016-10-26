package com.highluck.gamseong.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.highluck.gamseong.model.value.UserValue;

@Repository
public class FeedByUserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<?> findAllByUserId(UserValue value){
		
		StringBuilder query = new StringBuilder();
		List<?> list;
		query.append(
				"SELECT f "
				+ " FROM FEED f "
				+ " JOIN FETCH f.user "
				+ " JOIN FETCH f.location "
				+ " WHERE f.user.id = :id "
				+ " AND f.statusCode =  :status"	
				);
		
		if(value.getLocationId() != null && !value.getLocationId().equals("")){
			query.append(
					"AND f.location.id = :locationId "
					+ " OR f.location.motherId = :locationId "
					);
			list= entityManager.createQuery(query.toString())
					.setParameter("locationId",value.getLocationId())
					.setParameter("id", value.getId())
					.setParameter("status", "Y")
					.setFirstResult(value.getOffset())
					.setMaxResults(value.getLimit()) 
					.getResultList();	
		}
		else{
			list= entityManager.createQuery(query.toString())
					.setParameter("id", value.getId())
					.setParameter("status", "Y")
					.setFirstResult(value.getOffset())
					.setMaxResults(value.getLimit()) 
					.getResultList();	
		}
		
		query.append(" ORDER BY f.creationTime DESC");
		
		return list;
	}
}
