package com.bodybuilding.services.codechallenge.web.rest;

//import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bodybuilding.services.codechallenge.config.ParseConfigBean;
import com.bodybuilding.services.codechallenge.service.ParseService;


@Controller
public class ParseController {
	
	private final Logger log = LoggerFactory.getLogger(ParseController.class);
	
	@Autowired(required = true)
	private ParseService parseService;
	
	@Autowired(required = true)
	private ParseConfigBean parseConfigBean;
	
	

	
	
	public ParseController(){
		log.info("-=[ ParseController  constructor ]=-");
	}
	
	@RequestMapping(value = "/ReturnNavFromID", method = RequestMethod.GET)
	public
	@ResponseBody
	JSONObject ReturnNavFromID(@RequestParam String planID, HttpSession session)
	{
		
								
			log.info("-=[ calling ParseNavigationForID ]= PlanID is "+planID);
							
			return parseService.ParseNavigationForID(planID);
		
	}	
	
	@RequestMapping(value = "/ReturnNavForAllIDs", method = RequestMethod.GET)
	public
	@ResponseBody
	JSONObject ReturnNavForAllIDs(HttpSession session)
	{
		
								
			log.info("-=[ calling ReturnNavForAllIDs ]");
							
			return parseService.ParseNavigationForAllIDs();
		
	}	

}
