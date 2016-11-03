package com.highluck.gamseong.model.domain;


import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "LOCATION")
@org.hibernate.annotations.DynamicUpdate
public class Location {

	@Id
	@Column(name ="ID", nullable = false)
	private String id;
	@Column(name="MOTHER_ID", nullable = true)
	private String motherId;
	@Column(name="NAME")
	private String name;
	@Column(name="MOTHER_NAME", nullable = true)
	private String motherName;
	@Column(name="DESCRIPTION", nullable = true)
	private String description;
	@Column(name="IMAGE_URL", nullable = true)
	private String imageUrl;
	@Column(name="LOCAL_CODE")
	private int localCode;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="location")
	private Collection<Feed> feed;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMotherId() {
		return motherId;
	}
	public void setMotherId(String motherId) {
		this.motherId = motherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getLocalCode() {
		return localCode;
	}
	public void setLocalCode(int localCode) {
		this.localCode = localCode;
	}
	public Collection<Feed> getFeed() {
		return feed;
	}
	public void setFeed(Collection<Feed> feed) {
		this.feed = feed;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
}
