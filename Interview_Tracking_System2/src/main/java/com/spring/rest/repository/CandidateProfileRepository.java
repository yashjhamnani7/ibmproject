package com.spring.rest.repository;
import com.spring.entity.ITS_TBL_Candidate_Entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CandidateProfileRepository extends JpaRepository<ITS_TBL_Candidate_Entity,Long>
{
	ITS_TBL_Candidate_Entity getByCandidateId(long candidateId);
}




