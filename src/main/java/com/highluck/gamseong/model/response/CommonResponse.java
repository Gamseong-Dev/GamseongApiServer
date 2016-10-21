package com.highluck.gamseong.model.response;

public class CommonResponse {

	public final static String SUCCESS = "success";
	public final static String FAIL = "fail";
	public final static String AUTH_FAIL = "인증 실패";
	
	private String result;
	private String reason;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
