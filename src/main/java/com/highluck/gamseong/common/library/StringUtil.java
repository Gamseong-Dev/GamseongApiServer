package com.highluck.gamseong.common.library;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

	public String lPad(String str, int size, String fStr) {
	   
		byte[] b = str.getBytes();
	    int len = b.length;
	  
	    int tmp = size - len;
	  
	    for (int i=0; i < tmp ; i++){
	         str = fStr + str;
	    }
	    return str; 
	}
	
	public String rPad(String str, int size, String fStr){
		  
	    byte[] b = str.getBytes();
	    int len = b.length;
	  
	    int tmp = size - len;
	  
	    for (int i=0; i < tmp ; i++) {
	        str += fStr;
	    }
	    return str;
	}
	
	public String areaCodeCreateId(String code){
		
		return "D"+lPad(code, 3, "0");
	}
	
	public String localCodeCreateId(String areaCode, String localCode){
		
		return "S"+lPad(localCode, 3, "0") + lPad(areaCode, 3, "0");
	}
	
}
