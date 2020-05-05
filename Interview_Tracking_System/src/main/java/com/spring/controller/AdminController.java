package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.ITS_TBL_Candidate;
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.service.AdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	/*----AD-001-----*/
    	
	 @PostMapping(value="/add",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody Object registerCandidate(@RequestBody ITS_TBL_Candidate candidateProfile,@RequestHeader(name="auth-token") String authToken) 
	 {
		return adminService.saveCandidate(candidateProfile,authToken);
	
	 }
	 
	 /*-----------*/
	 
	 /*---AD-002----*/
	
	  @GetMapping(value="/search",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
			public@ResponseBody Object search(@RequestBody ITS_TBL_Candidate candidateProfile,@RequestHeader(name="auth-token") String authToken){
				return adminService.search(candidateProfile,authToken);
	  
		}
     /*-------*/	

	/*--------AD-003------------*/
	@PutMapping(value="/share",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object shareDetails(@RequestParam(required=true) String candidateId,@RequestParam(required=true) String number,@RequestHeader(name="auth-token") String authToken) {
		System.out.println(number);
		return adminService.shareDetails(Long.valueOf(candidateId), Integer.parseInt(number), authToken);
	}
	/*--------------------------*/
	
	/*-----------GET FREE PANEL-------------*/
	@GetMapping(value="/interviewer/{panel}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getFreeInterviewerList(@RequestParam(required=true) String date,
			@RequestParam(required=true) String time,@RequestHeader(name="auth-token") String authToken,@PathVariable(value="panel")String panel){
		if(panel.equalsIgnoreCase("tech"))
		return adminService.getFreeTechInterviewerList(date, time,authToken);
		else if(panel.equalsIgnoreCase("hr"))
		return adminService.getFreeHrInterviewerList(date, time,authToken);
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";			
	}
	/*--------------------------*/
	
	/*--------AD-004------------*/
	@PutMapping(value="/toTech",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object sendToTech(@RequestParam(required=true) long candidateId,@RequestParam(required=true) String date,@RequestParam(required=true) String time,@RequestParam(required=true) long interviewerId,@RequestParam(required=true) String subject,@RequestHeader(name="auth-token") String authToken) {
		return adminService.sendToTech(candidateId, date, time, interviewerId, subject,authToken);
	}	
	/*--------------------------*/
	
	/*----------GET TECH CLEARED-------------*/
	@GetMapping(value="/techCleared",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getTechCleared(){
		return adminService.getEligibleCandidates();		
	}	
	/*--------------------------*/
	
	
	/*--------AD-005------------*/
	@PutMapping(value="/toHr",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object sendToHr(@RequestParam(required=true) long interviewId,@RequestParam(required=true) String date,
						   @RequestParam(required=true) String time,@RequestParam(required=true) long empHrId,
						   @RequestHeader(name="auth-token") String authToken) {
		return adminService.sendToHr(interviewId, date, time, empHrId,authToken);
	}
	/*--------------------------*/
	
	/*--------AD-006------------*/
	@Autowired
	private AdminService microService;
	
	@GetMapping("/rating/{panel}")
	public Object getRatingsByInterviewId(@PathVariable(value="panel")String panel,@RequestParam(required=true) long interviewId,@RequestHeader(name="auth-token") String authToken)
	{
		if(panel.equalsIgnoreCase("hr"))
		return microService.getHRRating(interviewId,authToken);
		else if(panel.equalsIgnoreCase("tech"))
		return microService.getTechRating(interviewId,authToken);
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";	
	}
	/*--------------------------*/
	
	/*--------AD-007------------*/
	@PostMapping(value="/results/set", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object setInterviewResults(@RequestParam(required=true) long interviewId,@RequestParam(required=true) String result,@RequestHeader(name="auth-token") String authToken)
	{
		return microService.setInterviewResult(interviewId,result,authToken);
	}
	/*--------------------------*/
	
	/*--------AD-008------------*/

	@PostMapping(value="/results/share", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object shareInterviewResults(@RequestParam(required=true) long interviewId,@RequestParam(required=true) int shareResult,@RequestHeader(name="auth-token") String authToken)
	{
		return microService.shareInterviewResult(interviewId,shareResult,authToken);
	}	
	/*--------------------------*/
	
}
