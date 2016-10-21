package com.highluck.gamseong.common.library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.result.Output;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class HttpClientProxy{


	Logger log = Logger.getLogger(this.getClass());
	
	private static HttpClientProxy httpClientProxy;
	
	public static synchronized HttpClientProxy getHttpClientProxy(){
		if(httpClientProxy == null)
			httpClientProxy = new HttpClientProxy();
		
		return httpClientProxy;
	}
	
	public <T> ArrayList<T> get(String url, Class<T> tClass){
			
		Gson gson = null;
		BufferedReader reader;
		StringBuilder output = new StringBuilder();
		ArrayList<T> list = new ArrayList<T>();
		T t;
		
		try {
			 CloseableHttpClient httpclient = HttpClients.createDefault();
		     CloseableHttpResponse response = httpclient.execute(new HttpGet(url));
		     try {
		    	reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		    	
		    	String line = "";
                while (true) {                   
                    line = reader.readLine();
                    if (line == null) break;
                    
                    output.append(line + "\n");
                }      	
                reader.close();
                log.debug("json :" + output.toString());
                
		    	JsonObject root = new JsonParser().parse(output.toString()).getAsJsonObject()		       		  
									    			  .get("response").getAsJsonObject()
									    			  .get("body").getAsJsonObject()
									    			  .get("items").getAsJsonObject();		    	  
		    	JsonArray item = root.get("item").getAsJsonArray();
		    	
		    	gson = new Gson();
		    	  
		    	for(int i =0; i<item.size(); i++){
		    		t = gson.fromJson(item.get(i), tClass);
		    		list.add(t);
		    	}	
		    	
		     } finally {
		     response.close();
		     }   
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return list;
	}
}
