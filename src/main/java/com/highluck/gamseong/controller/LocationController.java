package com.highluck.gamseong.controller;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highluck.gamseong.model.domain.Location;
import com.highluck.gamseong.model.value.LocationValue;
import com.highluck.gamseong.model.web.LocationCode;
import com.highluck.gamseong.service.app.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/area/code", method = RequestMethod.GET)
	public ArrayList<Location> findAreaCodeAll(){
		
		return locationService.findAreaCodeAll();
	}
	//areaId = ? || id = ?
 	@RequestMapping(value = "{id}/local/code/", method = RequestMethod.GET)
	public ArrayList<Location> findLocalCodeAllById(@ModelAttribute LocationValue value){
		
		return locationService.findLocalCodeAllById(value);
	}
}
