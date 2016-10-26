package com.highluck.gamseong.service.app;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highluck.gamseong.model.domain.Event;
import com.highluck.gamseong.model.response.CommonResponse;
import com.highluck.gamseong.model.value.FeedValue;
import com.highluck.gamseong.model.value.LocationValue;
import com.highluck.gamseong.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private CommonResponse commonResponse;
	
	@Transactional(readOnly = true)
	public ArrayList<Event> findByTime(LocationValue value){
		
		value.setFromTime(Timestamp.valueOf(LocalDateTime.now()));
		value.setToTime(Timestamp.valueOf(LocalDateTime.now().plusDays(7)));
		
		return (ArrayList<Event>) eventRepository.findByTime(value);
	}
	
	@Transactional(readOnly = true)
	public ArrayList<Event> findAllByTime(LocationValue value){
		
		value.setFromTime(Timestamp.valueOf(LocalDateTime.now()));
		value.setToTime(Timestamp.valueOf(LocalDateTime.now().plusDays(7)));
		
		if(value.getLimit() == 0)
			value.setLimit(5);
		
		return (ArrayList<Event>) eventRepository.findAllByTime(value);
	}
	

	@Transactional(readOnly = false)
	public CommonResponse addLike(int id){
	
		eventRepository.addLike(id);	
		commonResponse.setResult(commonResponse.SUCCESS);;
		
		return commonResponse;
	}
}
