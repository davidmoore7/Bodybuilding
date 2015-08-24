package com.bodybuilding.services.codechallenge.config;

import javax.annotation.Resource;

@Resource
public class ParseConfigBean {
	
	
	private String JSONFile = "";
	
	
	

	public String getJSONFile(){
		return JSONFile;
	}
	
	public void setJSONFile(String JSONFileIn){
		JSONFile=JSONFileIn;
	}

}
