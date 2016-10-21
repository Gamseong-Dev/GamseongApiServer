package com.highluck.gamseong.service.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.common.LibraryContainer;
import com.highluck.gamseong.model.domain.Location;
import com.highluck.gamseong.model.value.LocationValue;
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
}
