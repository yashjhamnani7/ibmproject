package com.spring.json;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.spring.entity.ITS_TBL_User_Profile_Entity;

public class ITS_TBL_Candidate {

	
	private long candidateId; 
	private String primarySkills;
	private String secondarySkills;
	private int experience;
	private String qualification;
	private String designation;
	private int noticePeriod;
	private String location;
	private int shareDetails;
	public long getCandidateId() {
		return candidateId;
	}
	@OneToOne(cascade= CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name="CandidateId")
	private ITS_TBL_User_Profile_Json its_tbl_user_profile;
	public ITS_TBL_Candidate() {
		
		super();
	}

	public ITS_TBL_User_Profile_Json getIts_tbl_user_profile_entity() {
		return its_tbl_user_profile;
	}

	public void setIts_tbl_user_profile_entity(ITS_TBL_User_Profile_Json its_tbl_user_profile) {
		this.its_tbl_user_profile = its_tbl_user_profile;
	}

	public ITS_TBL_Candidate(long candidateId, String primarySkills, String secondarySkills, int experience,
			String qualification, String designation, int noticePeriod, String location, int shareDetails) {
		super();
		this.candidateId = candidateId;
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
		this.noticePeriod = noticePeriod;
		this.location = location;
		this.shareDetails = shareDetails;
	}
	
	
	public ITS_TBL_Candidate(String primarySkills, String secondarySkills, int experience, String qualification,
			String designation, int noticePeriod, String location, int shareDetails, ITS_TBL_User_Profile_Json getIts_tbl_user_profile_entity) {
		super();
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
		this.noticePeriod = noticePeriod;
		this.location = location;
		this.shareDetails = shareDetails;
		this.its_tbl_user_profile= getIts_tbl_user_profile_entity;
	}
	public ITS_TBL_Candidate(String primarySkills, String secondarySkills, int experience, String qualification) {
		super();
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.experience = experience;
		this.qualification = qualification;
	}
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
	public String getPrimarySkills() {
		return primarySkills;
	}
	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}
	public String getSecondarySkills() {
		return secondarySkills;
	}
	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getShareDetails() {
		return shareDetails;
	}
	public void setShareDetails(int shareDetails) {
		this.shareDetails = shareDetails;
	}	
}
