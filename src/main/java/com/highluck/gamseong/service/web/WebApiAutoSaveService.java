package com.highluck.gamseong.service.web;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.highluck.gamseong.common.LibraryContainer;
import com.highluck.gamseong.common.library.HttpClientProxy;

import com.highluck.gamseong.model.domain.Event;
import com.highluck.gamseong.model.domain.Location;

import com.highluck.gamseong.model.web.EventPublicData;
import com.highluck.gamseong.model.web.LocationCode;
import com.highluck.gamseong.repository.EventRepository;
import com.highluck.gamseong.repository.LocationRepository;



@Service
public class WebApiAutoSaveService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private LocationRepository localRepository;
	@Autowired
	private EventRepository eventRepositoy;
	@Autowired 
	private LibraryContainer libraryContainer;

	public ArrayList<LocationCode> findAll(){
		
		ArrayList<LocationCode> list = HttpClientProxy
				.getHttpClientProxy()
				.get(libraryContainer.getPublicData().areaCodeUrl(20, 1), LocationCode.class);
		
		return list;
	}

	public void autoLocalCodeSave(){
		
		ArrayList<LocationCode> list = HttpClientProxy
				.getHttpClientProxy()
				.get(libraryContainer.getPublicData().areaCodeUrl(20, 1), LocationCode.class);
				
				list.forEach( s -> {
					
					Location location = new Location();
					location.setId(libraryContainer.getStringUtil().areaCodeCreateId(s.getCode()));
					location.setName(s.getName());
					location.setLocalCode(Integer.valueOf(s.getCode()));
					
					localRepository.save(location);
					
				});
	}
	
	public void autoLocalAreaCodeSave(){
		
		for(int j=2; j<5; j++){
			for(int i =1; i<40; i++ ){
				if( i == 9) i = 31;
		
				ArrayList<LocationCode> list = HttpClientProxy
					.getHttpClientProxy()
					.get(libraryContainer.getPublicData().areaLocalCodeUrl(20, j , i), LocationCode.class);
			
					final int y = i;
					list.forEach( s -> {
						
						Location location = new Location();
						location.setId(libraryContainer.getStringUtil().localCodeCreateId(String.valueOf(y), s.getCode()));
						location.setName(s.getName());
						location.setLocalCode(Integer.valueOf(s.getCode()));
						location.setMotherId(libraryContainer.getStringUtil().areaCodeCreateId(String.valueOf(y)));
						
						localRepository.save(location);		
					});
			}
		}
	}
	
	public void autoEventAllSave(){
		
		for(int i =1; i<40; i++ ){
			if( i == 9) i = 31;
	
			ArrayList<EventPublicData> list = HttpClientProxy
				.getHttpClientProxy()
				.get(libraryContainer.getPublicData()
						.eventSearchUrlByDateAndAreaCode(100, 1, "20161201", "20170601", i), EventPublicData.class);
				
				list.forEach( s -> {
					Event event = new Event();
					try {
					
						event.setContents(s.getTitle());
						event.setCreationTime(libraryContainer.getDateUtil().timestampFromString(s.getCreatedtime()));
						event.setEndTime(libraryContainer.getDateUtil().dateFromString(s.getEventenddate()));
						event.setStartTime(libraryContainer.getDateUtil().dateFromString(s.getEventstartdate()));
						event.setLocationId(libraryContainer.getStringUtil().areaCodeCreateId(s.getAreacode()));
						event.setImageUrl(s.getFirstimage2());
						event.setAddress(s.getAddr1() + " " + s.getAddr2());
						eventRepositoy.save(event);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				});
		}
	}
	
	public void autoEventSaveBatch() throws ParseException{
		
		String startDate = libraryContainer.getDateUtil()
				.timestampToString(Timestamp.valueOf(LocalDateTime.now().plusDays(5)));
		
		ArrayList<EventPublicData> list = HttpClientProxy
				.getHttpClientProxy()
				.get(libraryContainer.getPublicData()
						.eventSearchUrlByStartDate(100, 1, startDate)
						, EventPublicData.class);
		
		list.forEach( s -> {
			Event event = new Event();
			try {
			
				event.setContents(s.getTitle());
				event.setCreationTime(libraryContainer.getDateUtil().timestampFromString(s.getCreatedtime()));
				event.setEndTime(libraryContainer.getDateUtil().dateFromString(s.getEventenddate()));
				event.setStartTime(libraryContainer.getDateUtil().dateFromString(s.getEventstartdate()));
				event.setLocationId(libraryContainer.getStringUtil().areaCodeCreateId(s.getAreacode()));
				event.setImageUrl(s.getFirstimage2());
				event.setAddress(s.getAddr1() + " " + s.getAddr2());
				log.debug("event -----" + event);
				eventRepositoy.save(event);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
