package com.highluck.gamseong.model.value;

import org.springframework.web.multipart.MultipartFile;

import com.highluck.gamseong.model.domain.Feed;

public class FeedPostValue {

	private MultipartFile sourceFile;
	private Feed feed;
	private String path;
	
	public MultipartFile getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(MultipartFile sourceFile) {
		this.sourceFile = sourceFile;
	}
	public Feed getFeed() {
		return feed;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
