package com.highluck.gamseong.model.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "FEED")
@org.hibernate.annotations.DynamicUpdate
public class Feed {

	public final static String NORMAL = "Y";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false, name ="ID")
	private long id;
	@Column(name="CONTENTS")
	private String contents;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LOCATION_ID" , referencedColumnName = "ID"
			,insertable=false ,updatable=false)
	private Location location;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID"
	,insertable=false ,updatable=false)
	private User user;
	
	@Column(name = "STATUS_CODE", nullable = true)
	private String statusCode;
	
	@Column(name = "LIKE_COUNT", nullable = true)
	private long likeCount;
	@Column(name = "REPLY_COUNT", nullable = true)
	private long replyCount;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name = "LOCATION_ID")
	private String locationId;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "CREATION_TIMESTAMP")
	private Timestamp creationTime;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "UPDATE_TIMESTAMP", nullable = true)
	private Timestamp updateTime;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FEED_ID", referencedColumnName = "ID"
	,insertable=true ,updatable=true)
	private Collection<Sticker> sticker;
	
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
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

	public Collection<Sticker> getSticker() {
		return sticker;
	}

	public void setSticker(Collection<Sticker> sticker) {
		this.sticker = sticker;
	}

	public long getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(long replyCount) {
		this.replyCount = replyCount;
	}

	@Override
	public String toString() {
		return "[" + id + "] feed";
	}
	
	/*
	 * FetchType.LAZY
	 * 연관을 맺고 있는 Entity들을 요청하는 순간 가져오는 설정이 LAZY ,
	 * FetchType.EAGER
	 * 해당 Entity를 가져올 때 미리 연관을 맺고 있는 Entity들까지 모두 가져오는 것이 EAGER 
	 * 
	 *  mappedBy="user" 관계의 주체가 되는쪽에서 설정
	 *  
	 *  orphanRemoval 
	 *  관계 Entity에서 변경이 일어난 경우 DB 변경을 같이 할지 결정
	 *  cascade와 다른것은 cascade는 JPA 레이어 수준이고 이것은 DB레이어에서 처리
	 *  기본은 fals
	 */
}
