package com.highluck.gamseong.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.model.domain.Event;
import com.highluck.gamseong.model.domain.Location;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.model.value.LocationValue;

@Repository
public class EventRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly=false)
	public void save(Event event){
		
		entityManager.persist(event);
		entityManager.flush();
	}
	
	public List<?> findByTime(LocationValue value){
		
		String query = 
				"SELECT e "
				+ " FROM EVENT e "		
				+ " WHERE e.locationId = :locationId "
				+ " AND e.startTime >= :fromTime "
				+ " AND e.startTime <= :toTime "
				+ " ORDER BY rand()";
		
		return entityManager.createQuery(query)
					 .setParameter("locationId", value.getId())
					 .setParameter("fromTime",value.getFromTime())	
					 .setParameter("toTime",value.getToTime())
					 .setMaxResults(1) 
					 .getResultList();
	}
	
	public List<?> findAllByTime(LocationValue value){
		
		String query = 
				"SELECT e "
						+ " FROM EVENT e "		
						+ " WHERE e.startTime >= :fromTime"
						+ " AND e.startTime <= :toTime"
						+ " ORDER BY rand()";
		
		return  entityManager.createQuery(query)
				 .setParameter("fromTime",value.getFromTime())	
				 .setParameter("toTime",value.getToTime())	
			     .setMaxResults(value.getLimit()) 
				 .getResultList();
	}
	
	public void addLike(int id){
		
		String query = 
				"UPDATE EVENT"
				+ " SET likeCount = likeCount + 1"
				+ " WHERE id = :id";
		
		entityManager.createQuery(query)
					.setParameter("id", id);
			
	}
}
