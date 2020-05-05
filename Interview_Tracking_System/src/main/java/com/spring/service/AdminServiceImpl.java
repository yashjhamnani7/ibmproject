package com.spring.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.ITS_TBL_Candidate_Entity;
import com.spring.entity.ITS_TBL_Hrpanel_Entity;
import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.entity.ITS_TBL_Techpanel_Entity;
import com.spring.entity.ITS_TBL_User_Credentials_Entity;
import com.spring.entity.ITS_TBL_User_Profile_Entity;
import com.spring.json.ITS_TBL_Candidate;
import com.spring.json.ITS_TBL_Interview_Schedule;
import com.spring.rest.repository.CandidateRepository;
import com.spring.rest.repository.HrpanelRepository;
import com.spring.rest.repository.InterviewScheduleRepository;
import com.spring.rest.repository.TechpanelRepository;
import com.spring.rest.repository.UserProfileRepository;
import com.spring.rest.repository.UserRepository;
import com.spring.utils.CandidateUtils;
import com.spring.utils.HrPanelUtils;
import com.spring.utils.InterviewScheduleUtils;
import com.spring.utils.TechPanelUtils;
import com.spring.utils.UserProfileUtils;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private InterviewScheduleRepository schdeduleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private CandidateRepository candidateRepository;
	
	@Autowired
	private TechService techService;
	
	@Autowired
	private TechpanelRepository techRepository;
	
	@Autowired
	private HrpanelRepository hrRepository;
	
	@Autowired
	private HrService hrservice;
	
	@Autowired
	private InterviewScheduleRepository interviewScheduleRepository;

	@Autowired
    private	UserProfileRepository userprofilerepo;
	
	
	/*-----AD-001---------*/
	@Override
		public Object  saveCandidate(ITS_TBL_Candidate  candidateProfile,String authToken)
		{
        List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		
		if(userList!=null && userList.size()!=0)
		{
			ITS_TBL_Candidate_Entity candidateEntity=candidateRepository.save(UserProfileUtils.convertCandidateProfileToCandidateProfileEntity(candidateProfile));
			
			long id= candidateEntity.getCandidateId();
			ITS_TBL_User_Profile_Entity userProfileEntity=UserProfileUtils.convertUserProfileToUserProfileEntity(candidateProfile);
			userProfileEntity.setCandidateId(id);
			ITS_TBL_User_Profile_Entity user=userprofilerepo.save(userProfileEntity);
			//ITS_TBL_User_Profile_Entity userProfileEntity=userprofilerepo.save(UserProfileUtils.convertUserProfileToUserProfileEntity(candidateProfile));
			ITS_TBL_Candidate its_candidate=UserProfileUtils.convertEntityToJson(candidateEntity,user);
			return its_candidate;
		}
		else
		{
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}
			
			
			/*
			ITS_TBL_Candidate_Entity //candidateProfileEntity = candidateprofilerepo.save(UserProfileUtils.convertCandidateProfileToCandidateProfileEntity(candidateProfile));
			//return UserProfileUtils.convertCandidateProfileEntityToCandidateProfile(candidateProfileEntity);*/
		}

	
	/*-----AD--002-------*/
	@Override
	public Object  search(ITS_TBL_Candidate  candidateProfile,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		
		if(userList!=null && userList.size()!=0)
		{
	 String qualification=candidateProfile.getQualification();
	 String skills=candidateProfile.getPrimarySkills();
	 int experience=candidateProfile.getExperience();
	 List<ITS_TBL_Candidate_Entity> listcan=candidateRepository.findByQualificationAndPrimarySkillsAndExperience(qualification, skills,experience);
	 
	 return UserProfileUtils.convertUserEntityListToUserList(listcan);
		}
		else
		{
		  return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}
	}
	
/*--------------------------*/
	
	
		/*--------AD-003------------*/
	public Object shareDetails(long candidate_id,int number,String authToken) {
	List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
	System.out.print(number);
	if(userList!=null && userList.size()!=0)
	{
	ITS_TBL_Candidate_Entity  candidateEntity= candidateRepository.findByCandidateId(candidate_id).get(0);
	candidateEntity.setShareDetails(Integer.valueOf(number));
	ITS_TBL_Candidate_Entity  candidateEntity_new=candidateRepository.save(candidateEntity);
	return CandidateUtils.convertCandidateEntityToCandidate(candidateEntity_new);
	}
	else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
	}
	/*--------------------------*/
	
	/*-----------------------------------GET FREE PANEL--------------------------------------*/
	
	/*-------------------------------------FOR TECH------------------------------------------*/
	@Override
	public Object getFreeTechInterviewerList(String date,String time,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		LocalDate localDate=LocalDate.parse(date);
		LocalTime localTime=LocalTime.parse(time);
		List<ITS_TBL_Techpanel_Entity> interviewList = new ArrayList<ITS_TBL_Techpanel_Entity>();
		List<ITS_TBL_Techpanel_Entity> techPanelList=techService.getAllTechPanel();
		techPanelList.stream().forEach(p1-> {
			
			if(p1.getInterviewScheduleList().size()==0)
			{
				if(!interviewList.contains(p1))  
					interviewList.add(p1);
			}
			else 
			{   
				Predicate<ITS_TBL_Interview_Schedule_Entity> pre=p->{
					//System.out.println(Math.abs(ChronoUnit.MINUTES.between(localTime, p.getInterviewTime())));
					if(p.getInterviewDate().equals(localDate)&&Math.abs(ChronoUnit.MINUTES.between(localTime, p.getInterviewTime()))<=119) {
						return true;
					}
					
					else
					{
						return false;
					}
				};
				if(!p1.getInterviewScheduleList().stream().filter(pre).findAny().isPresent())
				{
					interviewList.add(p1);
				}
				
			}
		});
		return TechPanelUtils.convertTechpanelToTechpanelList(interviewList) ;
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
	}
	
	/*----------------------------------------------FOR HR---------------------------------------------------------------------*/

	@Override
	public Object getFreeHrInterviewerList(String date,String time,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		LocalDate localDate=LocalDate.parse(date);
		LocalTime localTime=LocalTime.parse(time);
		List<ITS_TBL_Hrpanel_Entity> interviewList = new ArrayList<ITS_TBL_Hrpanel_Entity>();
		List<ITS_TBL_Hrpanel_Entity> HrPanelList=hrservice.getAllHrPanel();
		HrPanelList.stream().forEach(p1-> {
			
			if(p1.getInterviewScheduleList().size()==0)
			{
				if(!interviewList.contains(p1))  
					interviewList.add(p1);
			}
			else 
			{   
				Predicate<ITS_TBL_Interview_Schedule_Entity> pre=p->{
					System.out.println((p1.getEmpHrName()));
					if(p.getEmpHRInterviewDate().equals(localDate)&&Math.abs(ChronoUnit.MINUTES.between(localTime, p.getEmpHRInterviewTime()))<=119) {
						return true;
					}
					else
					{
						return false;
					}
				};
				if(!p1.getInterviewScheduleList().stream().filter(pre).findAny().isPresent())
				{
					interviewList.add(p1);
				}
				
			}
		});
		return HrPanelUtils.convertHrpanelEntityListToHrpanelList(interviewList) ;
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
	}
		
	/*------------------------------------------------------------------------------------------------------------------------------*/

	/*--------------------------------------------------AD-004---------------------------------------------------------------------*/
	@Override
	public Object sendToTech(long candidateId,String date,String time,long interviewerId,String subject,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity newInterview= new ITS_TBL_Interview_Schedule_Entity();
		LocalDate localDate=LocalDate.parse(date);
		LocalTime localTime=LocalTime.parse(time);
		newInterview.setCandidateEntity(candidateRepository.findByCandidateId(candidateId).get(0));
		newInterview.setInterviewDate(localDate);
		newInterview.setInterviewTime(localTime);
		newInterview.setTechEntity(techRepository.findByTechId(interviewerId).get(0));
		newInterview.setSubject(subject);
		interviewScheduleRepository.save(newInterview);
		return InterviewScheduleUtils.convertScheduleEntityToSchedule(newInterview);		
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		
	}
	/*------------------------------------------------------------------------------------------------------------------------------*/
	
	/*--------------------------------------------------GET TECH CLEARED-----------------------------------------------------------*/
	public Object getEligibleCandidates() {
		List<ITS_TBL_Interview_Schedule_Entity> interviewList=schdeduleRepository.findAll();
		List<ITS_TBL_Interview_Schedule_Entity> eligibleList= interviewList.stream().filter(interview->interview.getTechRating()>3?true:false).collect(Collectors.toList());
		List<Long> eligibleCandidateInterviewIdList=new ArrayList<Long>();
		List<String> noEligibleCandidateInterviewIdList=new ArrayList<String>();
		noEligibleCandidateInterviewIdList.add("No eligible candidates");
		for(int i=0;i<eligibleList.size();i++)
		{
			eligibleCandidateInterviewIdList.add(eligibleList.get(0).getInterviewId());
		}
		if(eligibleCandidateInterviewIdList.size()!=0)
		{
		return eligibleCandidateInterviewIdList;
		}
		else
		return noEligibleCandidateInterviewIdList;
	}
	/*--------------------------------------------------------------------------------------------------------------------------*/
	
	
	/*---------------------------------------------------AD-005-----------------------------------------------------------------*/
	@Override
	public Object sendToHr(long interviewId,String date,String time,long empHRId,String authToken){
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		ITS_TBL_Interview_Schedule_Entity newInterview= schdeduleRepository.findByInterviewId(interviewId);
		int checkTechclear=newInterview.getTechRating();
		if(userList!=null && userList.size()!=0 && newInterview!=null)
		{
		if(checkTechclear>3)
		{
		LocalDate localDate=LocalDate.parse(date);
		LocalTime localTime=LocalTime.parse(time);
		newInterview.setEmpHRInterviewDate(localDate);
		newInterview.setEmpHRInterviewTime(localTime);
		newInterview.setHrEntity(hrRepository.findByempHrId(empHRId).get(0));
		interviewScheduleRepository.save(newInterview);
		return InterviewScheduleUtils.convertScheduleEntityToSchedule(newInterview);		
		}
		else
		{
		return "{\"result\": \"failure\",\"message\": \"Candidate not eligile\"}";
		}
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		
	}
	/*--------------------------------------------------------------------------------------------------------------------------*/
	
	/*---------------------------------------------------AD-006-----------------------------------------------------------------*/
	
	/*-------------------------------------FOR HR------------------------------------------*/
	@Override
	public Object getHRRating(long interviewId,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interviewId);
			return scheduleEntity.getEmpHRRating();
		}
		else
		return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
		
		
	}
	/*-------------------------------------FOR TECH------------------------------------------*/
	
	@Override
	public Object getTechRating(long interviewId,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interviewId);
			return scheduleEntity.getTechRating();
			
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
	}
	/*--------------------------------------------------------------------------------------------------------------------------*/
	
	/*---------------------------------------------------AD-007-----------------------------------------------------------------*/
	public Object setInterviewResult(long interviewId,String result,String authToken)
	{
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interviewId);
		 scheduleEntity.setResult(result);
		 interviewScheduleRepository.save(scheduleEntity);	
		 return InterviewScheduleUtils.convertScheduleEntityToSchedule(scheduleEntity);
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
	}
	/*--------------------------------------------------------------------------------------------------------------------------*/
	

	/*---------------------------------------------------AD-008-----------------------------------------------------------------*/
	public Object shareInterviewResult(long interviewId,int shareResult,String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
		ITS_TBL_Interview_Schedule_Entity scheduleEntity=interviewScheduleRepository.findByInterviewId(interviewId);
		 scheduleEntity.setShareResult(shareResult);
		 return interviewScheduleRepository.save(scheduleEntity);		
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Session Id\"}";
		
	}
	/*--------------------------------------------------------------------------------------------------------------------------*/

	
	
	@Override
	public Object getInterviewByInterviewId(long interviewId,String authToken) {
		List<ITS_TBL_User_Credentials_Entity> userList=userRepository.findBysessionId(authToken);
		if(userList!=null && userList.size()!=0)
		{
			return InterviewScheduleUtils.convertScheduleEntityToSchedule(schdeduleRepository.findByInterviewId(interviewId));
		}
		else
			return "{\"result\": \"failure\",\"message\": \"Invalid Request\"}";
		}

}
