package com.highluck.gamseong.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.common.LibraryContainer;
import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.domain.Location;
import com.highluck.gamseong.model.value.LocationValue;
import com.highluck.gamseong.model.value.UserValue;

@Repository
public class LocationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly=false)
	public void save(Location location){
		
		entityManager.persist(location);
		entityManager.flush();
	}
	
	public List<?> findAreaCodeAll(){
		
		String query = 
				"SELECT l "
				+ " FROM LOCATION l "
				+ " WHERE l.motherId = :motherId "
				+ " ORDER BY l.localCode ASC";
		
		return entityManager.createQuery(query)
						.setParameter("motherId", "")
						.getResultList();	
	}
	
	public List<?> findLocalCodeAllById(LocationValue value){
		
		String query = 
				"SELECT l "
				+ " FROM LOCATION l "
				+ " WHERE l.motherId IS NULL "
				+ " ORDER BY l.localCode ASC";
		
		return entityManager.createQuery(query)
				.setParameter("motherId", value.getId())
				.getResultList();	
	}
	
	public List<?> findByUserId(UserValue value){
		/*
		 * 	 (SELECT c.id 
				FROM LOCATION c
				WHERE c.id 
				= (CASE WHEN a.mother_id IS NOT NULL 
				 	THEN a.mother_id
				 	ELSE a.id END)) AS id
			,(SELECT c.name 
				FROM LOCATION c
				WHERE c.id 
				= (CASE WHEN a.mother_id IS NOT NULL 
				 	THEN a.mother_id
				 	ELSE a.id END)) AS name
		 */
		String query = 
				"SELECT "
				+ " l.id,"
				+ " l.name"
				+ " FROM LOCATION l"
				+ " JOIN l.feed f"
				+ " WHERE f.userId = :userId"
				+ " GROUP BY l.id";
	
		return entityManager.createQuery(query)
				.setParameter("userId", value.getId())
				.getResultList();
	}
}
