package com.highluck.gamseong.model.domain;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "USER")
@org.hibernate.annotations.DynamicUpdate
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private String id;
	@Column
	private String account;
	@Column
	private String name;
	@Column(name="IMAGE_URL", nullable = true)
	private String imageUrl;
	
	@Transient
	@Column(name="ACCOUNT_DISTINCTION_CODE")
	private String accountDistinctionCode;
	
	@Transient
	@Column(name = "STATUS_CODE")
	private String statusCode;
	
	@Transient
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "CREATION_TIMESTAMP")
	private Timestamp creationTime;
	
	@Transient
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name = "UPDATE_TIMESTAMP", nullable = true)
	private Timestamp updateTime;
	
	@JsonIgnore
	@Column(name = "TOKEN_KEY")
	private String tokenKey;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getAccountDistinctionCode() {
		return accountDistinctionCode;
	}

	public void setAccountDistinctionCode(String accountDistinctionCode) {
		this.accountDistinctionCode = accountDistinctionCode;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}
	
}
