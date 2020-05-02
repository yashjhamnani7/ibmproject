package com.spring.json;

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
			String designation, int noticePeriod, String location, int shareDetails) {
		super();
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
		this.noticePeriod = noticePeriod;
		this.location = location;
		this.shareDetails = shareDetails;
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
