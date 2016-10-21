package com.highluck.gamseong.model.value;

public class FeedValue {
	
	public final static int DEFAULT_OFFSET = 0; 
	public final static int DEFAULT_LIMIT = 10; 
	public final static int DEFAULT_PAGE = 1; 
	
	private String id;
	private String locationId;
	private int offset;
	private int limit;
	private int pageNum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
}
