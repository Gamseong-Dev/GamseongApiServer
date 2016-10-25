package com.highluck.gamseong.model.value;

import java.sql.Timestamp;

public class FeedValue {
	
	public final static int DEFAULT_OFFSET = 0; 
	public final static int DEFAULT_LIMIT = 10; 
	public final static int DEFAULT_PAGE = 1; 
	
	private long id;
	private String userId;
	private String locationId;
	private int offset;
	private int limit;
	private int pageNum;
	private Timestamp fromTime;
	private Timestamp toTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public Timestamp getFromTime() {
		return fromTime;
	}
	public void setFromTime(Timestamp fromTime) {
		this.fromTime = fromTime;
	}
	public Timestamp getToTime() {
		return toTime;
	}
	public void setToTime(Timestamp toTime) {
		this.toTime = toTime;
	}
	
}
