package com.highluck.gamseong.service.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.common.LibraryContainer;
import com.highluck.gamseong.model.domain.Location;
import com.highluck.gamseong.model.value.LocationValue;
import com.highluck.gamseong.model.value.UserValue;
import com.highluck.gamseong.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	@Autowired 
	private LibraryContainer libraryContainer;
	
	@Transactional(readOnly = true)
	public ArrayList<Location> findAreaCodeAll(){
		
		return (ArrayList<Location>) locationRepository.findAreaCodeAll();
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Location> findLocalCodeAllById(LocationValue value){
		
		if(value.getId() == null)
		value.setId(libraryContainer.getStringUtil()
						.areaCodeCreateId(String.valueOf(value.getAreaCode())));
		
		return (ArrayList<Location>) locationRepository.findLocalCodeAllById(value);
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Location> findByUserId(UserValue value){
		
		return (ArrayList<Location>) locationRepository.findByUserId(value);
	}
	
	@Transactional(readOnly = true)
	public Location findByAddress(String address){
		
		String[] location = address.split("[ ]");
		LocationValue value = new LocationValue();
		value.setArea(location[0].substring(0, 2));
		value.setLocal(location[1]);
		System.out.println(value.getArea());
		return locationRepository.findByAddress(value);
	}
	
	@Transactional(readOnly = true)
	public List<Location> findByNameContaining(String name){
		return locationRepository.findByNameContaining(name);
	}
}
