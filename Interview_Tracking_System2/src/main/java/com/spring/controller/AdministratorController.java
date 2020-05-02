package com.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.*;

import com.spring.service.*;
@RestController
@RequestMapping("/app")
public class AdministratorController {

	
	
	private UserRegistrationService userService;

	@PostMapping(value="/admin/add", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ITS_TBL_User_Profile_Json registerUserProfile(@RequestBody ITS_TBL_User_Profile_Json userProfile) {
		return userService.save(userProfile);
	}
	
	@PostMapping(value="/admin/add/candidatedetails", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ITS_TBL_Candidate registerCandidate(@RequestBody ITS_TBL_Candidate candidateProfile) {
		return userService.saveCandidate(candidateProfile);
	}
	
		//@GetMapping(value="/admin/search/{candidateId}",produces=MediaType.APPLICATION_JSON_VALUE)
		//public Object candidateById(@PathVariable(name ="candidateId") String candidateId){
			//return userService.getCandidateById(Long.valueOf(candidateId));
		
				
	
}
