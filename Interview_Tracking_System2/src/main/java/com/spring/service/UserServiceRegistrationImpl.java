package com.spring.service;
import com.spring.json.ITS_TBL_Candidate;
import com.spring.json.ITS_TBL_User_Profile_Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ITS_TBL_User_Profile_Entity;

import com.spring.entity.ITS_TBL_Candidate_Entity;
import com.spring.rest.repository.CandidateProfileRepository;
import com.spring.rest.repository.UserProfileRepository;
import com.spring.utils.UserProfileUtils;

@Service
public class UserServiceRegistrationImpl implements UserRegistrationService
{

@Autowired
CandidateProfileRepository candidateprofilerepo;
UserProfileRepository userprofilerepo;


public ITS_TBL_User_Profile_Json  save(ITS_TBL_User_Profile_Json  userProfile)
	{
		ITS_TBL_User_Profile_Entity userProfileEntity = userprofilerepo.save(UserProfileUtils.convertUserProfileToUserProfileEntity(userProfile));
		return UserProfileUtils.convertUserProfileEntityToUserProfile(userProfileEntity);
	}
	
	public ITS_TBL_Candidate  saveCandidate(ITS_TBL_Candidate  candidateProfile)
	{
		ITS_TBL_Candidate_Entity candidateProfileEntity = candidateprofilerepo.save(UserProfileUtils.convertCandidateProfileToCandidateProfileEntity(candidateProfile));
		return UserProfileUtils.convertCandidateProfileEntityToCandidateProfile(candidateProfileEntity);
	}

	//public ITS_TBL_Candidate  search(ITS_TBL_Candidate  candidateProfile)
	//{
		
//	}



}
