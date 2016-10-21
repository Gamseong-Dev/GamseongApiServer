package com.highluck.gamseong.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.model.value.AuthValue;

@Repository
public class AuthRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public int authByToken(AuthValue value){
		
		String query = "SELECT u.id "
				+ " FROM USER u "
				+ " WHERE u.id = :id "
				+ " AND u.tokenKey = :token ";
		
		return entityManager.createQuery(query)
				 .setParameter("id", value.getId())
				 .setParameter("token", value.getToken())
				 .getResultList()
				 .size();
	}
}
