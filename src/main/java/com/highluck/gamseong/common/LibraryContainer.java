package com.highluck.gamseong.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.highluck.gamseong.common.library.DateUtil;
import com.highluck.gamseong.common.library.HttpClientProxy;
import com.highluck.gamseong.common.library.PublicData;
import com.highluck.gamseong.common.library.StringUtil;

@Component
public class LibraryContainer {

	@Autowired
	private PublicData publicData;
	@Autowired
	private StringUtil stringUtil;
	@Autowired
	private DateUtil dateUtil;
	
	public StringUtil getStringUtil() {
		return stringUtil;
	}
	public void setStringUtil(StringUtil stringUtil) {
		this.stringUtil = stringUtil;
	}
	public DateUtil getDateUtil() {
		return dateUtil;
	}
	public void setDateUtil(DateUtil dateUtil) {
		this.dateUtil = dateUtil;
	}
	public PublicData getPublicData() {
		return publicData;
	}
	public void setPublicData(PublicData publicData) {
		this.publicData = publicData;
	}
	
}
