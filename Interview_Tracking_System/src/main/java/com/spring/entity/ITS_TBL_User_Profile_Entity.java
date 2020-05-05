package com.spring.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITS_TBL_USER_PROFILE")
public class ITS_TBL_User_Profile_Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="CANDIDATEID")
	private long candidateId;
   
	
	

    public long getCandidateId() {
		return candidateId;
	}

	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id", referencedColumnName="CANDIDATEID")
    private ITS_TBL_User_Profile_Entity user;
	


	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public ITS_TBL_User_Profile_Entity getUser() {
		return user;
	}
	public void setUser(ITS_TBL_User_Profile_Entity user) {
		this.user = user;
	}



	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="DATEOFBIRTH")
	private LocalDate dateOfBirth;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	public ITS_TBL_User_Profile_Entity(long candidateId,String firstName,
			String lastName, LocalDate dateOfBirth, String gender, String street, String location, String city,
			String state, String pincode, String mobileNo, String emailId,ITS_TBL_Candidate_Entity candidateDetail) {
		super();
		
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	@Column(name="PINCODE")
	private String pincode;
	
	@Column(name="MOBILENO")
	private String mobileNo;
	
	@Column(name="EMAILID")
	private String emailId;

	public ITS_TBL_User_Profile_Entity() {
		
	}

	

	
	public ITS_TBL_User_Profile_Entity( String firstName, String lastName, LocalDate dateOfBirth,
			String gender, String street, String location, String city, String state, String pincode, String mobileNo,
			String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	
	
	
	public ITS_TBL_User_Profile_Entity(long candidateId, String firstName, String lastName, LocalDate dateOfBirth,
			String gender, String street, String location, String city, String state, String pincode, String mobileNo,
			String emailId) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public void setEmailId(String emailId) 
	
	{
		this.emailId = emailId;
	}
	@Override
	public String toString() 
	{
		return "ITS_TBL_User_Profile_Entity [candidateId="  + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", street=" + street
				+ ", location=" + location + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + "]";
	}	
	
		
}
