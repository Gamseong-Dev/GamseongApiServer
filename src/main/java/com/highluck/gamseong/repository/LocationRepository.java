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
import com.highluck.gamseong.repository.interfaces.LocationInterface;

@Repository
public class LocationRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private LocationInterface locationInterface;

	@Transactional(readOnly=false)
	public void save(Location location){
		
		entityManager.persist(location);
		entityManager.flush();
	}
	
	public List<?> findAll(){
		String query = 
				"SELECT l "
				+ " FROM LOCATION l "
				+ " ORDER BY l.localCode ASC";
		
		return entityManager.createQuery(query)
				.getResultList();	
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
				+ " WHERE l.motherId = :motherId "
				+ " ORDER BY l.localCode ASC";
		
		return entityManager.createQuery(query)
				.setParameter("motherId", value.getId())
				.getResultList();	
	}
	
	public Location findByAddress(LocationValue value){
		
		String query = 
				"SELECT l "
				+ " FROM LOCATION l"
				+ " WHERE l.motherId = "
					+ " ( SELECT o "
						+ " FROM LOCATION o "
						+ " WHERE o.name LIKE :area||'%'"
						+ " AND o.motherId = :motherId "
						+ ")"
				+ " AND l.name = :local";
		
		return (Location) entityManager.createQuery(query)
				.setParameter("area", value.getArea())
				.setParameter("local", value.getLocal())
				.setParameter("motherId", "")
				.getSingleResult();
	}
	
	public List<?> findBest(LocationValue value){
		
		String query =
				"SELECT l"	
				+ " FROM LOCATION l "
				+ " JOIN l.feed f "
				+ " WHERE f.creationTime >= :fromTime "
					+ " AND f.creationTime <= :toTime "
				+ " GROUP BY l.id "
				+ " ORDER BY COUNT(f.id) DESC";
	
		return  entityManager.createQuery(query)
				 .setParameter("fromTime",value.getFromTime())	
				 .setParameter("toTime",value.getToTime())	
			     .setMaxResults(value.getLimit()) 
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
	
	public List<Location> findByNameContaining(String name){
		
		return locationInterface.findByNameContaining(name);
	}
}
