package com.highluck.gamseong.model.value;

import java.sql.Timestamp;

public class LocationValue {
	
	private String id;
	private int areaCode;
	private int localCode;
	private int pageNum;
	private int numOfRows;
	private Timestamp toTime;
	private Timestamp fromTime;
	private int limit;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public int getLocalCode() {
		return localCode;
	}
	public void setLocalCode(int localCode) {
		this.localCode = localCode;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public Timestamp getToTime() {
		return toTime;
	}
	public void setToTime(Timestamp toTime) {
		this.toTime = toTime;
	}
	public Timestamp getFromTime() {
		return fromTime;
	}
	public void setFromTime(Timestamp fromTime) {
		this.fromTime = fromTime;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
