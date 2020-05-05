package com.spring.json;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;

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
	private List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList;
	
	
	
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
		this.interviewScheduleList = interviewScheduleList;
		
	}
	public List<ITS_TBL_Interview_Schedule_Entity> getInterviewScheduleList() {
		return interviewScheduleList;
	}
	public void setInterviewScheduleList(List<ITS_TBL_Interview_Schedule_Entity> interviewScheduleList) {
		this.interviewScheduleList = interviewScheduleList;
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
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String street;
	
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private String emailId;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	@OneToOne(cascade= CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="its_tbl_user_profile_entity")
	@JoinColumn(name="CandidateId")
	
	
	@Override
	public String toString() {
		return "ITS_TBL_User_Profile_Json [candidateId=" + candidateId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", street=" + street
				+ ", location=" + location + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + "]";
	}
	

    public ITS_TBL_Candidate() {
		super();
	}






	public ITS_TBL_Candidate(String primarySkills, String secondarySkills, int experience, String qualification,
			String designation, int noticePeriod, String location, int shareDetails, String firstName, String lastName,
			LocalDate dateOfBirth, String gender, String street, String city, String state, String pincode,
			String mobileNo, String emailId) {
		super();
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
		this.noticePeriod = noticePeriod;
		this.location = location;
		this.shareDetails = shareDetails;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}



	public ITS_TBL_Candidate(long candidateId, String primarySkills, String secondarySkills, int experience,
			String qualification, String designation, int noticePeriod, String location, int shareDetails,
			String firstName, String lastName, LocalDate dateOfBirth, String gender, String street, String city,
			String state, String pincode, String mobileNo, String emailId) {
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
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	
	
	
	
}
