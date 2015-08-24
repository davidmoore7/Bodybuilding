package com.bodybuilding.services.codechallenge.parse;

import org.json.simple.JSONObject;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.ArrayList;


import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import com.bodybuilding.services.codechallenge.parse.data.WebsiteData;


public class ParseNaviagtionJSON {

	private static ParseNaviagtionJSON instance=null;
	
	private ArrayList<WebsiteData> navigation = new ArrayList<WebsiteData>();
	
	private String jsonFileToProcess = "";
	
	protected ParseNaviagtionJSON(String fileName){
		System.out.println("testtesttesttesttesttesttesttest");
		System.out.println("testtesttesttesttesttesttesttest");
		
		processNavJSON();
		System.out.println("testtesttesttesttesttesttesttest");
		System.out.println("testtesttesttesttesttesttesttest");
	}
	
   public static ParseNaviagtionJSON getInstance(String fileName) {
	      if(instance == null) {
	    	 
	         instance = new ParseNaviagtionJSON(fileName);
	      }
	      return instance;
   }
	
	private JSONArray parseArray(JSONObject objectToParse){
		JSONArray returnArray=(JSONArray) objectToParse.get("children");
		
		return returnArray;
	}
	
	private WebsiteData parseJSONToObject(JSONObject objectToPersist){
		WebsiteData websiteData = new WebsiteData();
		if (objectToPersist!=null){
			if (objectToPersist.containsKey("id")){
				websiteData.setID(objectToPersist.get("id").toString());
			}
			if (objectToPersist.containsKey("name")){
				websiteData.setName(objectToPersist.get("name").toString());
			}
			if (objectToPersist.containsKey("url")){
				websiteData.setURL(objectToPersist.get("url").toString());
			}
			websiteData.setJsonObject(objectToPersist);
		}
		
		return websiteData;
	}
	
	private ArrayList parseChildren(JSONObject jsonObjectToParse, ArrayList<WebsiteData> nav){
		boolean continueProcessing = true;
		boolean hasChildren = false;
		
		
		    JSONArray currentArray=parseArray(jsonObjectToParse);
		    for (int i=0; i< currentArray.size();i++){
		    	JSONObject currentObject = (JSONObject)currentArray.get(i);
		    	if (currentObject!=null){		    	 	
		    	  WebsiteData currentNavPos = parseJSONToObject(currentObject);
		    	  nav.add(currentNavPos);
		    	  if (currentObject.containsKey("children")){
		    		  parseChildren(currentObject,nav);
		    	  }
		    	}  
		    }
		
		
		return nav;
	}
	 
	private ArrayList processNavJSON(){
		
		
		File jsonFile = new File("C://test/bbnav.json");
		
		try {
			// read the json file
			   FileReader reader = new FileReader(jsonFile.getCanonicalPath());
			   System.out.println("1");
			   
			   
			    
				JSONParser jsonParser = new JSONParser();
				System.out.println("2");
				JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
				
				
				
				System.out.println("3");
				System.out.println("jsonObject.size() "+jsonObject.size());
				JSONArray testAll = new JSONArray();
				
				JSONArray topArray = (JSONArray) jsonObject.get("children");
				System.out.println("topArray size "+topArray.size());
				JSONArray currentArray=topArray;
				for (int i=0; i < topArray.size();i++){
					JSONObject currentObject=(JSONObject) topArray.get(i);
					System.out.println("currentObject id "+currentObject.get("id"));
					WebsiteData currentNavPos = parseJSONToObject(currentObject);
					if (currentNavPos!=null){
						navigation.add(currentNavPos);	
					}
					 
					if (currentObject!=null && currentObject.containsKey("children")){
						currentArray=parseArray(currentObject);
						navigation=parseChildren(currentObject,navigation);
						/*
						for (int k=0; k < currentArray.size(); k++){
							JSONObject childObject = (JSONObject)currentArray.get(k);
							currentNavPos = parseJSONToObject(childObject);
							if (currentNavPos!=null){
								navigation.add(currentNavPos);	
							}
						}
						*/
					}
				}
				
				
				}catch(Exception e){
					System.out.println("oops "+e.getMessage());
					e.getStackTrace();
				}
		
		return navigation;
	}
	
	public ArrayList<WebsiteData> getNavigation(){
		System.out.println("getting Naviation");
		return navigation;
	}
	
	private String getJsonFileToProcess(){
		return jsonFileToProcess;
	}
	
	private void setJsonFileToProcess(String jsonFileToProcessIn){
		jsonFileToProcess=jsonFileToProcessIn;
	}
	
	public static void main(String[] args){
		ParseNaviagtionJSON parseNav =ParseNaviagtionJSON.getInstance("C://test/bbnav.json");
		 File currentFile = new File("C://test/bbnav.json");
	      System.out.println("Test1");
	      //File currentFile = new File("test.simple.JSON");
		 //parseNav.readBBJSONFILE(currentFile);
		 //ArrayList<WebsiteData> testNav=parseNav.testIterator(currentFile);
	      ArrayList<WebsiteData> testNav=parseNav.getNavigation();
		 if (testNav!=null && testNav.size()>0){
			 for (int i=0; i < testNav.size(); i++){
				 WebsiteData currentNav=testNav.get(i);
				 if (currentNav!=null && currentNav.getID().equalsIgnoreCase("30dayweek1")){
					 System.out.println("ID is "+currentNav.getID());
					 System.out.println("Name is "+currentNav.getName());
					 System.out.println("URL is "+currentNav.getURL());
				 }
			 }
		 }
		 
		 ParseNaviagtionJSON parseNav1 =ParseNaviagtionJSON.getInstance("C://test/bbnav.json");
		 testNav=parseNav1.getNavigation();
	}

}
