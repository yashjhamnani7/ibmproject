package com.spring.service;

import java.util.List;

import com.spring.json.ITS_TBL_Candidate;

public interface AdminService {
	
	public Object getInterviewByInterviewId(long interviewId,String authtoken);
	public Object shareDetails(long candidate_id,int number, String authtoken);
	public Object sendToTech(long candidateId,String date,String time,long interviewerId,String subject,String authtoken);
	public Object getFreeTechInterviewerList(String date,String tim,String authtokene);
	public Object getHRRating(long interviewId,String authtoken);
	public Object getTechRating(long interviewId,String authtoken);
	public Object setInterviewResult(long interviewId,String result,String authtoken);
	public Object shareInterviewResult(long interviewId,int shareResult,String authtoken);
	public Object sendToHr(long interviewId, String date, String time, long empHRId, String authToken);
	public Object getFreeHrInterviewerList(String date, String time, String authToken);	
	public Object getEligibleCandidates();
	public Object saveCandidate(ITS_TBL_Candidate  candidateProfile,String authToken);
//	public Object getCandidateById(Long candidateId);
	public Object  search(ITS_TBL_Candidate  candidateProfile,String authToken);
	
} 
