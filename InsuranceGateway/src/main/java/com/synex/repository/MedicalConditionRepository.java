package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.MedicalCondition;

public interface MedicalConditionRepository extends JpaRepository<MedicalCondition, Long>{

	@Transactional
	@Modifying
	@Query(
	  value = 
	    "insert into familymember_medicalcondition (FamilyMember_familyMemberId, medicalConditions_medicalConditionId) values (?1, ?2)",
	  nativeQuery = true)
	public void setRelation(Long familyMemberId, Long medicalConditionId);
	
}
