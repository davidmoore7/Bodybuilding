package com.bodybuilding.test;

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
import java.util.Vector;
import java.util.ArrayList;


import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import com.bodybuilding.test.data.WebsiteData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class ParseJSON {
	
	   public void readJSONFILE(File jsonFile){
		   
		   try {
				// read the json file
		   FileReader reader = new FileReader(jsonFile.getCanonicalPath());

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			// get a String from the JSON object
			// get a String from the JSON object
						String firstName =  (String) jsonObject.get("firstname");
						System.out.println("The first name is: " + firstName);

						// get a number from the JSON object
						long id =  (long) jsonObject.get("id");
						System.out.println("The id is: " + id);

						// get an array from the JSON object
						JSONArray lang= (JSONArray) jsonObject.get("languages");
						
						// take the elements of the json array
						for(int i=0; i<lang.size(); i++){
							System.out.println("The " + i + " element of the array: "+lang.get(i));
						}
						Iterator i = lang.iterator();

						// take each value from the json array separately
						while (i.hasNext()) {
							JSONObject innerObj = (JSONObject) i.next();
							System.out.println("language "+ innerObj.get("lang") + 
									" with level " + innerObj.get("knowledge"));
						}
						// handle a structure into the json object
						JSONObject structure = (JSONObject) jsonObject.get("job");
						System.out.println("Into job structure, name: " + structure.get("name"));


		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

			   	 
	   }
	
public void readBBJSONFILE(File jsonFile){
	JSONParser parser=new JSONParser();
		   try {
				// read the json file
		   FileReader reader = new FileReader(jsonFile.getCanonicalPath());
		   System.out.println("1");
		    
			JSONParser jsonParser = new JSONParser();
			System.out.println("2");
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			System.out.println("3");
			System.out.println("jsonObject.size() "+jsonObject.size());
			
			// get a String from the JSON object
			// get a String from the JSON object
			/*            
			Iterator i = muscle.iterator();		
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();
				System.out.println("id "+ innerObj.get("id") + 
						" with level " + innerObj.get("URL"));
			}
			*/
			for (int j=0; j< jsonObject.size(); j++){
				
				Object currentObj=jsonObject.get(j);
				//String currentID=currentObj.toString();
				JSONArray muscle = (JSONArray) jsonObject.get("children");
				
				for(int i=0; i<muscle.size(); i++){
					JSONObject childObject=(JSONObject) muscle.get(i);
					
				    String testID=childObject.toString();
				    //System.out.println("testID "+testID);
				    //if (childObject.containsValue("30day")){
				    		
				    	 	
                     if (childObject.get("id").equals("Training_Main")){
                    	 JSONArray training = (JSONArray) childObject.get("children");	
                    	 for(int k=0; k<training.size(); k++){
                    		 JSONObject trainObject=(JSONObject) training.get(k);
                    		 if (trainObject.get("id").equals("find-a-plan")){
                    			 JSONArray planning = (JSONArray) trainObject.get("children");
                    			 if (planning.indexOf("children") > 0){
                    				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    				 System.out.println("array present");
                    				 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    			 }
                    			 for (int g=0; g<planning.size(); g++){
                    				JSONObject planObject=(JSONObject) planning.get(g); 
                    				System.out.println(planObject.get("id"));
                    		        System.out.println("URL is : "+planObject.get("url"));
                    				if (planObject.get("id").equals("30day")){
                    					System.out.println(planObject.get("id"));
                        		        System.out.println("URL is : "+planObject.get("url"));
                    				}else if (planObject.get("id").equals("30daymain")){
                    					System.out.println(planObject.get("id"));
                        		        System.out.println("URL is : "+planObject.get("url"));
                    				}else if (planObject.get("id").equals("Training")){
                    					System.out.println(planObject.get("id"));
                        		        System.out.println("URL is : "+planObject.get("url"));
                    				}
                    				
                    				
                    				
                    		        
                    			 }   
                    		 
                    		 }
                    	 }
					    
				    }
				}       
			            
			           // System.out.println("currentID "+currentID);
			            /*
			            if (currentID!=null && currentID.equalsIgnoreCase("Training_Main")){
			            	JSONArray muscle = (JSONArray) jsonObject.get("children");
							System.out.println("4");
							// take the elements of the json array
							for(int i=0; i<muscle.size(); i++){
							    String testID=(String) jsonObject.get("id");
							    if (testID!=null && testID.equalsIgnoreCase("30day")){
								   System.out.println("The " + i + " element of the array: "+muscle.get(i));
							    }
							}
							
                           */
							// take each value from the json array separately
			            /*
							while (i.hasNext()) {
								JSONObject innerObj = (JSONObject) i.next();
								System.out.println("id "+ innerObj.get("id") + 
										" with level " + innerObj.get("URL"));
							}
							*/
			            	
			            //}
						
						// handle a structure into the json object
						//JSONObject structure = (JSONObject) jsonObject.get("job");
						//System.out.println("Into job structure, name: " + structure.get("name"));
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

			   	 
	   }

       public ArrayList popWebsiteData(File jsonFile){
    	   ArrayList<WebsiteData> list = null;
    	   try{
    	   FileReader reader = new FileReader(jsonFile.getCanonicalPath());
		   System.out.println("1");
		    
			JSONParser jsonParser = new JSONParser();
			System.out.println("2");
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			System.out.println("3");
			System.out.println("jsonObject.size() "+jsonObject.size());
			
    	   String jsonString = jsonObject.toJSONString();
    	   System.out.println("jsonString "+jsonString);
    			   ObjectMapper mapper = new ObjectMapper();
    			  
    			   list = mapper.readValue(reader, 
    					  new TypeReference<ArrayList<WebsiteData>>() {});
    	   }catch(Exception e){
    		   System.out.println("Mucslehead sucks "+e.getMessage());
    		   e.getStackTrace();
    	   }
    	   
    	   return list;
       }

	   public String populateJSON(File jsonFile){
		  
		   String retVal = "";
		    int read, N = 1024 * 1024;
		    char[] buffer = new char[N];
		    int count=-1;

		    try {
		        FileReader fileReader = new FileReader(jsonFile);
		        BufferedReader br = new BufferedReader(fileReader);
                count=0;
		        while(true) {
		            read = br.read(buffer, 0, N);
		            if (count>7){
		            	System.out.println("currentLine "+new String(buffer, 0, read));
		            }
		            
		            retVal += new String(buffer, 0, read);

		            if(read < N) {
		                break;
		            }
		        }
		        fileReader.close();
		        br.close();
		    } catch(Exception ex) {
		        ex.printStackTrace();
		    }
		   
		   return retVal;
	   }
	   
	   private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }

		  public static JSONObject readJsonFromUrl(String url) throws IOException, Exception {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONObject json = new JSONObject();
		      JSONParser jsonParser = new JSONParser();
		      json = (JSONObject)jsonParser.parse(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
		  }
		
	   public void parseWebSitePage(){
		   String sURL = "http://dmoorenb:8080/OrderService/orderCheck.html"; //just a string
           try{
		    // Connect to the URL using java's native library
		    URL url = new URL(sURL);
		    HttpURLConnection request = (HttpURLConnection) url.openConnection();
		    request.connect();
            System.out.println("test1");
		    // Convert to a JSON object to print data
		    JsonParser jp = new JsonParser(); //from gson
		    System.out.println("test2");
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
		    System.out.println("test3");
		    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
		    System.out.println("test4");
		    String rootVal = rootobj.get("td").getAsString(); //just grab the zipcode
		    System.out.println("test5");
		    System.out.println("root"+rootVal);
		    System.out.println("test6");
           }catch(Exception e){
        	   System.out.println("Error "+e.getMessage());
           }
	   }
	   
	   public void testGSON(){
		   Gson gson = new Gson();

			try {

				BufferedReader br = new BufferedReader(
					new FileReader("C://test/bbnav.json"));

				//convert the json string back to object
				WebsiteData obj = gson.fromJson(br, WebsiteData .class);

				System.out.println(obj);

			} catch (IOException e) {
				System.out.println("testGSON() "+e.getMessage());
				e.printStackTrace();
			}
	   }
	   
	   public static void main(String[] args) 
	   {
	      JSONParser parser=new JSONParser();
	      ParseJSON parseJSON = new ParseJSON();
	      String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
	      
	      File currentFile = new File("C://test/bbnav777.json");
	      
	      //File currentFile = new File("test.simple.JSON");
	      //parseJSON.readBBJSONFILE(currentFile);
	      //ArrayList siteValues=parseJSON.popWebsiteData(currentFile);
	      try{
	    	  parseJSON.testGSON();
	    	  /*
	    	  JSONObject json = parseJSON.readJsonFromUrl("https://graph.facebook.com/19292868552");
	    	  
	    	    System.out.println(json.toString());
	    	    System.out.println(json.get("id"));
	    	    */
	      }catch(Exception e){
	    	  System.out.println("Error in main "+e.getMessage());
	    	  e.getStackTrace();
	      }
	      //parseJSON.parseWebSitePage();
	      /*
	      if (siteValues!=null && siteValues.size()>0){
	    	  for (int i=0;i<siteValues.size();i++){
	    		 WebsiteData currentData =  (WebsiteData) siteValues.get(i);
	    		 System.out.println("ID "+currentData.getID());
	    	  }
	      }
	      */
	      /*String navJSON=parseJSON.populateJSON(currentFile);
	      if (navJSON!=null){
	    	  System.out.println(navJSON);
	      }else{
	    	  System.out.println("FILE IS NULL!!");
	      }
	      try{
	         Object obj = parser.parse(navJSON);
	         JSONArray array = (JSONArray)obj;
	         System.out.println("Array size "+array.size());
	         System.out.println("The 2nd element of array");
	         System.out.println(array.get(0));
	         System.out.println();
             /*
	         JSONObject obj2 = (JSONObject)array.get(1);
	         System.out.println("Field \"1\"");
	         System.out.println(obj2.get("1"));    

	         s = "{}";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s= "[5,]";
	         obj = parser.parse(s);
	         System.out.println(s+" "+obj);

	         s= "[5,,2]";
	         obj = parser.parse(s);
	         System.out.println(s+" "+obj);
	         */
	      /*
	      }catch(ParseException e){
	         System.out.println("position: " + e.getPosition());
	         System.out.println(e);
	         e.printStackTrace();
	      }
	      */
	   }
        
	

}
