package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.*;
import com.spring.entity.*;
import com.spring.service.*;
@RestController
@RequestMapping("/app")
@CrossOrigin(origins="*")
public class AdministratorController {

	
	@Autowired
	private UserRegistrationService userService;

	@PostMapping(value="/admin/add",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ITS_TBL_Candidate registerCandidate(@RequestBody ITS_TBL_Candidate candidateProfile) {
		return userService.saveCandidate(candidateProfile);
	}
	
	//public @ResponseBody ITS_TBL_Candidate registerCandidate(@RequestBody ITS_TBL_Candidate candidateProfile) {
@GetMapping(value="/admin/search",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
		public@ResponseBody List<ITS_TBL_Candidate> search(@RequestBody ITS_TBL_Candidate candidateProfile){
			return userService.search(candidateProfile);
}
}
