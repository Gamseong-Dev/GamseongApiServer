package com.highluck.gamseong.model.value;

import java.io.Serializable;

public class LikeValue implements Serializable{

	private long feedId;
	private String userId;
	
	public long getFeedId() {
		return feedId;
	}
	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
