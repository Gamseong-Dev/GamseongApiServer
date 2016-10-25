package com.highluck.gamseong.controller;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highluck.gamseong.model.domain.Event;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.model.value.LocationValue;
import com.highluck.gamseong.service.app.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public ArrayList<Event> findAllByTime(@ModelAttribute LocationValue value){
		
		return eventService.findAllByTime(value);
	}
	
	@RequestMapping(value ="/locations/{id}", method = RequestMethod.GET)
	public ArrayList<Event> findByTime(@ModelAttribute LocationValue value){
		
		return eventService.findByTime(value);
	}
	/*
	@RequestMapping(value ="/{id}/like", method = RequestMethod.GET)
	public  Callable<CommonResponse> addLike(@PathVariable("id")int id){
		
		return () -> {
			return eventService.addLike(id);	
		};
	}*/
}
