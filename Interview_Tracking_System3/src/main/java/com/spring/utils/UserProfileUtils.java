package com.spring.utils;

import com.spring.json.ITS_TBL_User_Profile_Json;
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
		candidateEntityList.stream().forEach(consumer);
		return candidateList;
	}
	
	
	public static ITS_TBL_User_Profile_Json convertUserProfileEntityToUserProfile(ITS_TBL_User_Profile_Entity userProfileEntity) {
		return new ITS_TBL_User_Profile_Json(userProfileEntity.getFirstName(),userProfileEntity.getLastName(),userProfileEntity.getDateOfBirth(),userProfileEntity.getGender(),userProfileEntity.getStreet(),userProfileEntity.getLocation()
					,userProfileEntity.getCity(),userProfileEntity.getState(),userProfileEntity.getPincode(),userProfileEntity.getMobileNo(),userProfileEntity.getEmailId());
	}

	public static ITS_TBL_User_Profile_Entity convertUserProfileToUserProfileEntity(ITS_TBL_User_Profile_Json userProfile) {
		return new ITS_TBL_User_Profile_Entity(userProfile.getFirstName(),userProfile.getLastName(),userProfile.getDateOfBirth(),userProfile.getGender(),userProfile.getStreet(),userProfile.getLocation()
				,userProfile.getCity(),userProfile.getState(),userProfile.getPincode(),userProfile.getMobileNo(),userProfile.getEmailId());
	}
	
	
	public static ITS_TBL_Candidate convertCandidateProfileEntityToCandidateProfile(ITS_TBL_Candidate_Entity candidateProfileEntity) {
		return new ITS_TBL_Candidate(candidateProfileEntity.getCandidateId(),candidateProfileEntity.getPrimarySkills(),candidateProfileEntity.getSecondarySkills(),candidateProfileEntity.getExperience(),
				candidateProfileEntity.getQualification(),candidateProfileEntity.getDesignation(),candidateProfileEntity.getNoticePeriod(),
				candidateProfileEntity.getLocation(),candidateProfileEntity.getShareDetails());
				
	}
	public static ITS_TBL_Candidate_Entity convertCandidateProfileToCandidateProfileEntity(ITS_TBL_Candidate candidateProfile) {
		return new ITS_TBL_Candidate_Entity(candidateProfile.getCandidateId(),candidateProfile.getPrimarySkills(),candidateProfile.getSecondarySkills(),candidateProfile.getExperience(),
				candidateProfile.getQualification(),candidateProfile.getDesignation(),candidateProfile.getNoticePeriod(),
				candidateProfile.getLocation(),candidateProfile.getShareDetails());
			
	}
	
	

}
	
