package com.highluck.gamseong.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.highluck.gamseong.model.domain.Location;

@Repository
public interface LocationInterface extends CrudRepository<Location, String>{
	
	Location findByName(String name);
	
	Location findByNameAndMotherId(String name, String motherId);
	
	List<Location> findByNameContaining(String name); 
}
