package com.highluck.gamseong.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highluck.gamseong.model.domain.Location;
import com.highluck.gamseong.model.value.LocationValue;
import com.highluck.gamseong.model.value.UserValue;
import com.highluck.gamseong.model.web.LocationCode;
import com.highluck.gamseong.service.app.LocationService;

import ch.qos.logback.access.pattern.RequestMethodConverter;
import io.undertow.attribute.RequestMethodAttribute;

@RestController
@RequestMapping("/locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/code", method = RequestMethod.GET)
	public ArrayList<Location> findAll(){
		
		return locationService.findAll();
	}
	
	@RequestMapping(value = "/best", method = RequestMethod.GET)
	public ArrayList<Location> findBest(@ModelAttribute LocationValue value){
		
		return locationService.findBest(value);
	}
	
	@RequestMapping(value = "/area/code", method = RequestMethod.GET)
	public ArrayList<Location> findAreaCodeAll(){
		
		return locationService.findAreaCodeAll();
	}
	//areaId = ? || id = ?
 	@RequestMapping(value = "/{id}/local/code", method = RequestMethod.GET)
	public ArrayList<Location> findLocalCodeAllById(@ModelAttribute LocationValue value){
		
		return locationService.findLocalCodeAllById(value);
	}
 	
 	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
 	public ArrayList<Location> findByUserId(@ModelAttribute UserValue value){
 		
 		return locationService.findByUserId(value);
 	}
 	
 	@RequestMapping(value = "/address/{address}", method = RequestMethod.GET)
 	public Location findByName(@PathVariable String address){
 		
 		return locationService.findByAddress(address);
 	}
 	
 	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
 	public Callable<List<Location>> findByNameContaining(@PathVariable String name){
 		
 		return () -> {
 			return locationService.findByNameContaining(name);
 		};
 	}
}
