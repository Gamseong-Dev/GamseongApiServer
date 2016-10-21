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
						.setParameter("motherId", null)
						.getResultList();	
	}
	
	public List<?> findLocalCodeAllById(LocationValue value){
		
		String query = 
				"SELECT l "
				+ " FROM LOCATION l "
				+ " WHERE l.motherId = :motherId "
				+ " ORDER BY l.localCode ASC";
		
		return entityManager.createQuery(query)
				.setParameter("motherId", value.getId())
				.getResultList();	
	}
}
