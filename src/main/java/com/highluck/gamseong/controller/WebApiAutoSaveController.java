package com.highluck.gamseong.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.highluck.gamseong.model.value.LocationValue;
import com.highluck.gamseong.model.web.LocationCode;
import com.highluck.gamseong.service.app.FeedService;
import com.highluck.gamseong.service.web.WebApiAutoSaveService;

@RestController
@RequestMapping("/auto")
public class WebApiAutoSaveController {
	
	@Autowired
	private WebApiAutoSaveService webApiAutoSavelService;
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public ArrayList<LocationCode> test(){
		
		return webApiAutoSavelService.findAll();
	}
	
	@RequestMapping(value ="/area/code", method = RequestMethod.POST)
	public void autoLocalCodeSave(){
		
		webApiAutoSavelService.autoLocalCodeSave();
	}
	
	@RequestMapping(value ="/area/local/code", method = RequestMethod.POST)
	public void autoLocalAreaCodeSave(){
		
		webApiAutoSavelService.autoLocalAreaCodeSave();
	}
		
	@RequestMapping(value ="/event/info", method = RequestMethod.POST)
	public void autoEventAllSave(){
		
		webApiAutoSavelService.autoEventAllSave();
	}
	
	//@RequestMapping(value ="/event/info/batch", method = RequestMethod.POST)
	@Scheduled(cron = "0 0 5 * * *") // 매일 5시 실행
	public void autoEventSaveBatch() throws ParseException{
		webApiAutoSavelService.autoEventSaveBatch();
	}
}
