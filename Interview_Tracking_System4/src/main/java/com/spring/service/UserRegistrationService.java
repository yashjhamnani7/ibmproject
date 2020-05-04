package com.spring.service;


import java.util.List;

import com.spring.json.*;

public interface UserRegistrationService 
{
	//public ITS_TBL_User_Profile_Json  save(ITS_TBL_User_Profile_Json  userProfile);
	public ITS_TBL_Candidate  saveCandidate(ITS_TBL_Candidate  candidateProfile);
//	public Object getCandidateById(Long candidateId);
	List<ITS_TBL_Candidate>  search(ITS_TBL_Candidate  candidateProfile);
	//public ITS_TBL_Candidate  search(ITS_TBL_Candidate  candidateProfile);
	
}
