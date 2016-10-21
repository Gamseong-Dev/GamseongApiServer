package com.highluck.gamseong.model.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "REPLY")
@org.hibernate.annotations.DynamicUpdate
public class Reply {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false, name ="ID")
	private long id;
	@Column(name="CONTENTS")
	private String contents;
	@Column(name="MOTHER_ID", nullable = true)
	private String motherId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID"
	,insertable=false ,updatable=false)
	private User user;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "FEED_ID", referencedColumnName = "ID"
	,insertable=false ,updatable=false)
	private Feed feed;
	
	@Column(name="USER_ID")
	private String userId;
	@Column(name="FEED_ID")
	private long feedId;
	
	@Column(name = "STATUS_CODE", nullable = true)
	private String statusCode;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "CREATION_TIMESTAMP")
	private Timestamp creationTime;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "UPDATE_TIMESTAMP", nullable = true)
	private Timestamp updateTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getMotherId() {
		return motherId;
	}
	public void setMotherId(String motherId) {
		this.motherId = motherId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Feed getFeed() {
		return feed;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getFeedId() {
		return feedId;
	}
	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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
}
