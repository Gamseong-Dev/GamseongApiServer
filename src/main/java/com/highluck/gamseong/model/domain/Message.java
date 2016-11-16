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

@Entity(name = "MESSAGE")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false, name ="ID")
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "RECIVE_USER_ID", referencedColumnName = "ID"
	,insertable=false ,updatable=false)
	private User reciveUser;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "SEND_USER_ID", referencedColumnName = "ID"
	,insertable=false ,updatable=false)
	private User sendUser;
	
	@Column(name="SEND_USER_ID")
	private String sendUserId;
	@Column(name="RECIVE_USER_ID")
	private String reciveUserId;
	@Column(name="CONTENTS")
	private String contents;
	@Column(name="SEND_TIMESTAMP")
	private Timestamp sendTime;
	
	@Column(name="STATUS")
	private String status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getSendUser() {
		return sendUser;
	}
	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}
	public User getReciveUser() {
		return reciveUser;
	}
	public void setReciveUser(User reciveUser) {
		this.reciveUser = reciveUser;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getReciveUserId() {
		return reciveUserId;
	}
	public void setReciveUserId(String reciveUserId) {
		this.reciveUserId = reciveUserId;
	}
	
}
