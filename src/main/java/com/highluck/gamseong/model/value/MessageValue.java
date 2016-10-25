package com.highluck.gamseong.model.value;

public class MessageValue {

	private long id;
	private String sendUserId;
	private String reciveUserId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
