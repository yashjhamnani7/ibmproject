package com.spring.service;
import com.spring.json.ITS_TBL_Candidate;

import java.util.List;

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
@Autowired
UserProfileRepository userprofilerepo;



	
	public ITS_TBL_Candidate  saveCandidate(ITS_TBL_Candidate  candidateProfile)
	{
		ITS_TBL_Candidate_Entity candidateEntity=candidateprofilerepo.save(UserProfileUtils.convertCandidateProfileToCandidateProfileEntity(candidateProfile));
		
		long id= candidateEntity.getCandidateId();
		ITS_TBL_User_Profile_Entity userProfileEntity=UserProfileUtils.convertUserProfileToUserProfileEntity(candidateProfile);
		userProfileEntity.setCandidateId(id);
		ITS_TBL_User_Profile_Entity user=userprofilerepo.save(userProfileEntity);
		//ITS_TBL_User_Profile_Entity userProfileEntity=userprofilerepo.save(UserProfileUtils.convertUserProfileToUserProfileEntity(candidateProfile));
		ITS_TBL_Candidate its_candidate=UserProfileUtils.convertEntityToJson(candidateEntity,user);
		return its_candidate;
		   
		
		
		/*
		ITS_TBL_Candidate_Entity //candidateProfileEntity = candidateprofilerepo.save(UserProfileUtils.convertCandidateProfileToCandidateProfileEntity(candidateProfile));
		//return UserProfileUtils.convertCandidateProfileEntityToCandidateProfile(candidateProfileEntity);*/
	}

	public List<ITS_TBL_Candidate>  search(ITS_TBL_Candidate  candidateProfile)
	{
	 String qualification=candidateProfile.getQualification();
	 String skills=candidateProfile.getPrimarySkills();
	 int experience=candidateProfile.getExperience();
	 List<ITS_TBL_Candidate_Entity> listcan=candidateprofilerepo.findByQualificationAndPrimarySkillsAndExperience(qualification, skills,experience);
	 
	 return UserProfileUtils.convertUserEntityListToUserList(listcan);

	}



}
