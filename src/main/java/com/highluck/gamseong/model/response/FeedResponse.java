package com.highluck.gamseong.model.response;

import java.util.ArrayList;

import javax.persistence.Basic;
import javax.persistence.FetchType;

import com.highluck.gamseong.model.domain.Feed;
import com.highluck.gamseong.model.domain.Reply;

public class FeedResponse {

	private Feed feed;
	private ArrayList<Reply> reply;
	private long userLikeStatus;
	
	public Feed getFeed() {
		return feed;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}
	public ArrayList<Reply> getReply() {
		return reply;
	}
	public void setReply(ArrayList<Reply> reply) {
		this.reply = reply;
	}
	public long getUserLikeStatus() {
		return userLikeStatus;
	}
	public void setUserLikeStatus(long userLikeStatus) {
		this.userLikeStatus = userLikeStatus;
	}
}
