package com.spring.utils;


import com.spring.entity.ITS_TBL_User_Profile_Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.*;
import com.spring.json.*;

public class UserProfileUtils {

	public static List<ITS_TBL_Candidate> convertUserEntityListToUserList(List<ITS_TBL_Candidate_Entity> candidateEntityList) {
		final List<ITS_TBL_Candidate> candidateList = new ArrayList<ITS_TBL_Candidate>();
		Consumer<ITS_TBL_Candidate_Entity> consumer = (ITS_TBL_Candidate_Entity candidateEntity)->candidateList.add(convertCandidateProfileEntityToCandidateProfile(candidateEntity));
		
		
		//consumer=((ITS_TBL_Candidate_Entity candidateEntity)->candidateList.add(convertCandidateProfileEntityToUserProfile(candidateEntity)));
		candidateEntityList.stream().forEach(consumer);
		return candidateList;
	}

	

public static ITS_TBL_Candidate convertCandidateProfileEntityToCandidateProfile(ITS_TBL_Candidate_Entity candidateProfile)
{
	
	return new ITS_TBL_Candidate(candidateProfile.getCandidateId(),candidateProfile.getPrimarySkills(),candidateProfile.getSecondarySkills(),candidateProfile.getExperience(),
			candidateProfile.getQualification(),candidateProfile.getDesignation(),candidateProfile.getNoticePeriod(),
			candidateProfile.getLocation(),candidateProfile.getShareDetails());
}
	
	public static ITS_TBL_User_Profile_Entity convertUserProfileToUserProfileEntity(ITS_TBL_Candidate userProfile) {
		return new ITS_TBL_User_Profile_Entity(userProfile.getFirstName(),userProfile.getLastName(),userProfile.getDateOfBirth(),userProfile.getGender(),userProfile.getStreet(),userProfile.getLocation()
				,userProfile.getCity(),userProfile.getState(),userProfile.getPincode(),userProfile.getMobileNo(),userProfile.getEmailId());
	}
	public static ITS_TBL_Candidate convertEntityToJson(ITS_TBL_Candidate_Entity candidateProfile,ITS_TBL_User_Profile_Entity userProfile)
	{
		
		return new ITS_TBL_Candidate(candidateProfile.getCandidateId(),candidateProfile.getPrimarySkills(),candidateProfile.getSecondarySkills(),candidateProfile.getExperience(),
				candidateProfile.getQualification(),candidateProfile.getDesignation(),candidateProfile.getNoticePeriod(),
				candidateProfile.getLocation(),candidateProfile.getShareDetails(),userProfile.getFirstName(),userProfile.getLastName(),userProfile.getDateOfBirth(),userProfile.getGender(),userProfile.getStreet()
				,userProfile.getCity(),userProfile.getState(),userProfile.getPincode(),userProfile.getMobileNo(),userProfile.getEmailId());
	}
	

	
	
	//public static ITS_TBL_Candidate convertCandidateProfileEntityToCandidateProfile(ITS_TBL_Candidate_Entity candidateProfileEntity) {
		//return new ITS_TBL_Candidate(candidateProfileEntity.getCandidateId(),candidateProfileEntity.getPrimarySkills(),candidateProfileEntity.getSecondarySkills(),candidateProfileEntity.getExperience(),
			//	candidateProfileEntity.getQualification(),candidateProfileEntity.getDesignation(),candidateProfileEntity.getNoticePeriod(),
				//candidateProfileEntity.getLocation(),candidateProfileEntity.getShareDetails());
				
//	}
	public static ITS_TBL_Candidate_Entity convertCandidateProfileToCandidateProfileEntity(ITS_TBL_Candidate candidateProfile) {
		return new ITS_TBL_Candidate_Entity(candidateProfile.getCandidateId(),candidateProfile.getPrimarySkills(),candidateProfile.getSecondarySkills(),candidateProfile.getExperience(),
				candidateProfile.getQualification(),candidateProfile.getDesignation(),candidateProfile.getNoticePeriod(),
				candidateProfile.getLocation(),candidateProfile.getShareDetails());
			
	}
	
	

}
	
