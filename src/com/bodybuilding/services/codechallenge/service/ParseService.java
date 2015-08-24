package com.bodybuilding.services.codechallenge.service;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
//import java.util.ArrayList;
import java.util.Vector;
import java.util.Arrays;
import com.bodybuilding.services.codechallenge.config.ParseConfigBean;
import com.bodybuilding.services.codechallenge.parse.ParseNaviagtionJSON;
import com.bodybuilding.services.codechallenge.parse.data.WebsiteData;


@Service
public class ParseService {
	
    @Autowired(required = true)
    private ParseConfigBean configBean;
    private final Logger logger                     = LoggerFactory.getLogger(ParseService.class);
    private ParseNaviagtionJSON parseNav =null;
    
    
    public JSONObject ParseNavigationForID(String planID){
    	JSONObject retVal=null;
    	parseNav =ParseNaviagtionJSON.getInstance(configBean.getJSONFile());
    	ArrayList<WebsiteData> testNav=parseNav.getNavigation();
    	
    	 if (testNav!=null && testNav.size()>0){
			 for (int i=0; i < testNav.size(); i++){
				 WebsiteData currentNav=testNav.get(i);
				 if (currentNav!=null && currentNav.getID().equalsIgnoreCase(planID)){
					 System.out.println("ID is "+currentNav.getID());
					 System.out.println("Name is "+currentNav.getName());
					 System.out.println("URL is "+currentNav.getURL());
					 retVal=currentNav.getJsonObject();
					 break;
				 }
			 }
		 }
    	 
    	 if (retVal==null){
    		 retVal = new JSONObject();
    		 retVal.put("id", "404");
    		 retVal.put("name", "Not Found");
    		 retVal.put("URL", "http://na.na");

    	 }
    	
    	return retVal;
    }
    
    public JSONObject ParseNavigationForAllIDs(){
    	JSONObject retVal=null;
    	
    	return retVal;
    }
    
    public static void main(String[] args){
    	ParseService parseServ= new ParseService();
    	parseServ.ParseNavigationForID("30day");
    }

}
