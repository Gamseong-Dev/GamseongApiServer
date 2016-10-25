package com.highluck.gamseong.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

@Entity(name = "STICKER" )
@org.hibernate.annotations.DynamicUpdate
public class Sticker {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false, name ="ID")
	private long id;
	@Column(name="CODE")
	private String code;
	/*
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name = "FEED_ID", referencedColumnName = "ID",insertable=false ,updatable=false)
	private Feed feed;
	*/
	@Transient
	@Column(name = "FEED_ID")
	private Long feedId;
	
	@Column(name="CONTENTS")
	private String contents;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
/*
	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}
*/
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Long getFeedId() {
		return feedId;
	}

	public void setFeedId(Long feedId) {
		this.feedId = feedId;
	}

}
