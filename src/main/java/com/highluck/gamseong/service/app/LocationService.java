package com.highluck.gamseong.service.app;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.common.LibraryContainer;
import com.highluck.gamseong.model.domain.Event;
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
	
	public ArrayList<Location> findAll(){
		
		final ArrayList<Location> list = (ArrayList<Location>) locationRepository.findAll();
		list.forEach(s -> {
			if(!s.getMotherName().equals("not")){
				s.setName(s.getMotherName() + " " + s.getName());
			}
		});
		
		return list;
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Location> findAreaCodeAll(){
		
		return (ArrayList<Location>) locationRepository.findAreaCodeAll();
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Location> findLocalCodeAllById(final LocationValue value){
		
		if(value.getId() == null)
		value.setId(libraryContainer.getStringUtil()
						.areaCodeCreateId(String.valueOf(value.getAreaCode())));
		
		return (ArrayList<Location>) locationRepository.findLocalCodeAllById(value);
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Location> findByUserId(final UserValue value){
		
		return (ArrayList<Location>) locationRepository.findByUserId(value);
	}
	
	@Transactional(readOnly = true)
	public Location findByAddress(final String address){
		
		final String[] location = address.split("[ ]");
		final LocationValue value = new LocationValue();
		value.setArea(location[0].substring(0, 2));
		value.setLocal(location[1]);

		return locationRepository.findByAddress(value);
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Location> findBest(final LocationValue value){
		
		value.setFromTime(Timestamp.valueOf(LocalDateTime.now().minusDays(7)));
		value.setToTime(Timestamp.valueOf(LocalDateTime.now()));
		
		if(value.getLimit() == 0)
			value.setLimit(5);
		
		return (ArrayList<Location>) locationRepository.findBest(value);
	}
	
	@Transactional(readOnly = true)
	public List<Location> findByNameContaining(final String name){
		return locationRepository.findByNameContaining(name);
	}
}
