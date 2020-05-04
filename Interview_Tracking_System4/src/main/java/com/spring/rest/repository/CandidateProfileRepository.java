package com.spring.rest.repository;
import com.spring.entity.ITS_TBL_Candidate_Entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface CandidateProfileRepository extends JpaRepository<ITS_TBL_Candidate_Entity,Long>
{
	//ITS_TBL_Candidate_Entity getByCandidateId(long candidateId);
	@Query(value="SELECT * FROM its_tbl_candidate WHERE QUALIFICATION = :quali AND PRIMARYSKILLS = :skills AND EXPERIENCE=:experience" ,nativeQuery = true)
    List<ITS_TBL_Candidate_Entity> findByQualificationAndPrimarySkillsAndExperience(@Param("quali") String qualification, @Param("skills") String skills,@Param("experience") int experience);
}






