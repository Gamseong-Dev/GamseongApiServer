package com.highluck.gamseong.common.library;

import org.springframework.stereotype.Component;

@Component
public class PublicData {
	
	public final static String PUBLIC_KEY = "ServiceKey=jS1heVGQzXhGff%2BseSOlm422QtXijhCC7diJnIHMg%2BGlhwZJHkVl92J3IRNtFq415WfqLlL4sKLFlThW6UZFhA%3D%3D";
	public final static String PUBLIC_LOCAL_URL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
	public final static String TYPE_JSON = "&_type=json";
	public final static String DEVICE = "&MobileOS=ETC&MobileApp=GAMSEONG";
	public final static String RESULT_NUM = "&numOfRows=";
	public final static String PAGE_NO = "&pageNo=";
	public final static String AREA_CODE = "&areaCode=";
	
	public final static String EVENT_START_DATE = "&eventStartDate=";
	public final static String EVENT_END_DATE = "&eventEndDate=";
	public final static String SEARCH_FESTIVAL = "searchFestival?";
	
	public String areaCodeUrl(int resultNum, int pageNo){
		String url = PUBLIC_LOCAL_URL + "areaCode?" + PUBLIC_KEY + RESULT_NUM  + resultNum
				+PAGE_NO + pageNo + DEVICE + TYPE_JSON;	

		return url;
	}
	
	public String areaLocalCodeUrl(int resultNum, int pageNo, int areaCode){
		String url = PUBLIC_LOCAL_URL + "areaCode?" + PUBLIC_KEY + RESULT_NUM  + resultNum
				+PAGE_NO + pageNo + AREA_CODE + areaCode + DEVICE + TYPE_JSON;	
		
		return url;
	}
	
	public String eventSearchUrlByStartDate(int resultNum, int pageNo, String startDate){
		String url = PUBLIC_LOCAL_URL + SEARCH_FESTIVAL + PUBLIC_KEY + RESULT_NUM  + resultNum
				+PAGE_NO + pageNo + DEVICE + EVENT_START_DATE + startDate + TYPE_JSON;	
		
		return url;
	}
	
	public String eventSearchUrlByDateAndAreaCode(int resultNum, int pageNo, String startDate, String endDate, int areaCode){
		String url = PUBLIC_LOCAL_URL + SEARCH_FESTIVAL + PUBLIC_KEY + RESULT_NUM  + resultNum
				+PAGE_NO + pageNo + AREA_CODE + areaCode + DEVICE + EVENT_START_DATE + startDate + EVENT_END_DATE + endDate + TYPE_JSON;	
		
		return url;
	}
}
