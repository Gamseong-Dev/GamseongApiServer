package com.highluck.gamseong.common.library;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UtfEncoder {

	private static UtfEncoder encoder;
	public static UtfEncoder getEncoder(){
		if(encoder == null) 
			encoder = new UtfEncoder();
		return encoder;	
	}
	
	public String urlEncoderUTF(String url) throws UnsupportedEncodingException{
		
		return URLEncoder.encode(url,"UTF-8");
	}
}
