package com.bodybuilding.test.data;

import org.json.simple.JSONObject;

public class WebsiteData {
	
	
	private String id = "";	
	private String name = "";	
	private String url="";
	
	private JSONObject jsonObject = new JSONObject();
	
	
	public WebsiteData(){
		
	}
	
	public String getID(){
		return id;
	}
	
	public void setID(String idIn){
		id=idIn;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String nameIn){
		name=nameIn;
	}
	
	public String getURL(){
		return url;
	}
	
	public void setURL(String urlIn){
		url=urlIn;
	}
	
	public JSONObject getJsonObject(){
		return jsonObject;
	}
	
	public void setJsonObject(JSONObject jsonObjectIn){
		jsonObject=jsonObjectIn;
	}
	
}
