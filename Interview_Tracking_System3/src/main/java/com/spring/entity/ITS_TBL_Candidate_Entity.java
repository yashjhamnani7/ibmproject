package com.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="its_tbl_candidate")

public class ITS_TBL_Candidate_Entity {
	
	
	@Id
	@GeneratedValue 	            
	@Column(name="CANDIDATEID")
	private long candidateId;
	
	@Column(name="PRIMARYSKILLS")
	private String primarySkills;
	
	@Column(name="SECONDARYSKILLS")
	private String secondarySkills;
	
	@Column(name="EXPERIENCE")
	private int experience;
	
	@Column(name="QUALIFICATION")
	private String qualification;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="NOTICEPERIOD")
	private int noticePeriod;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="SHAREDETAILS")
	private int shareDetails;
	
	
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JoinColumn(name="CandidateId")
	//private List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList;
	
	
	
	@OneToOne(cascade= CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name="CANDIDATEID")
	private ITS_TBL_User_Profile_Entity its_tbl_user_profile_entity;
	
	public ITS_TBL_Candidate_Entity() {
		super();
	}
	public ITS_TBL_User_Profile_Entity getIts_tbl_user_profile_entity() {
		return its_tbl_user_profile_entity;
	}
	public void setIts_tbl_user_profile_entity(ITS_TBL_User_Profile_Entity its_tbl_user_profile_entity) {
		this.its_tbl_user_profile_entity = its_tbl_user_profile_entity;
	}
	public long getCandidateId() {
		return candidateId;
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
	//public List<ITS_TBL_Interview_Schedule_Entity> getInterviewScheduleList() {
		//return interviewScheduleList;
	//}
	//public void setInterviewScheduleList(List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList) {
		//this.interviewScheduleList = interviewScheduleList;
	//}
	public ITS_TBL_Candidate_Entity(long candidateId, String primarySkills, String secondarySkills, int experience,
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
	
	
	public ITS_TBL_Candidate_Entity(String primarySkills, String secondarySkills, int experience, String qualification,
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
	public ITS_TBL_Candidate_Entity(String primarySkills, String secondarySkills, int experience, String qualification,
			String designation, int noticePeriod, String location, int shareDetails,
			ITS_TBL_User_Profile_Entity its_tbl_user_profile_entity) {
		super();
		
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
		this.noticePeriod = noticePeriod;
		this.location = location;
		this.shareDetails = shareDetails;
		this.its_tbl_user_profile_entity = its_tbl_user_profile_entity;
	}
	
	

}
