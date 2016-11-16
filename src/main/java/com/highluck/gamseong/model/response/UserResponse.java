package com.highluck.gamseong.model.response;

import com.highluck.gamseong.model.domain.User;

public class UserResponse {

	private User user;
	private int feedCount;
	private int localCount;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFeedCount() {
		return feedCount;
	}
	public void setFeedCount(int feedCount) {
		this.feedCount = feedCount;
	}
	public int getLocalCount() {
		return localCount;
	}
	public void setLocalCount(int localCount) {
		this.localCount = localCount;
	}
}
