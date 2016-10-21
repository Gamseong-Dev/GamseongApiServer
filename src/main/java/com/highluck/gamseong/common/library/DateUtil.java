package com.highluck.gamseong.common.library;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	public Timestamp timestampFromString(String strDate) throws ParseException{
		
		SimpleDateFormat fromFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
		return  Timestamp.valueOf(toFormat.format(fromFormat.parse(strDate)));
	}	
	
	public Timestamp dateFromString(String strDate) throws ParseException{
		
		SimpleDateFormat fromFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
		return  Timestamp.valueOf(toFormat.format(fromFormat.parse(strDate)));
	}	
	
	public String timestampToString(Timestamp date) throws ParseException{
		
		SimpleDateFormat toFormat = new SimpleDateFormat("yyyyMMdd");
		
		return toFormat.format(date);
	}	
}
