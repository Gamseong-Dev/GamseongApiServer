package com.highluck.gamseong.model.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "EVENT")
@org.hibernate.annotations.DynamicUpdate
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, name ="ID")
	private long id;
	
	@Column(name="LOCATION_ID")
	private String locationId;
	@Column(name="CONTENTS")
	private String contents;
	
	@Column(name="IMAGE_URL", nullable = true)
	private String imageUrl;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "START_TIMESTAMP")
	private Timestamp startTime;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "END_TIMESTAMP")
	private Timestamp endTime;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "CREATION_TIMESTAMP")
	private Timestamp creationTime;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "UPDATE_TIMESTAMP", nullable = true)
	private Timestamp updateTime;
	@Column(name="ADDRESS")
	private String address;
	@Column(name = "LIKE_COUNT", nullable = true)
	private int likeCount;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Timestamp getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
}
