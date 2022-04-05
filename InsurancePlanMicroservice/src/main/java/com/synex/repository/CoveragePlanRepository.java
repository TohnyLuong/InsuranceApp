package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.CoveragePlan;



public interface CoveragePlanRepository extends JpaRepository<CoveragePlan, Long> {
	
	@Transactional
	@Modifying
	@Query(
	  value = 
	    "insert into coverageplan_benefit (CoveragePlan_coverageTierId, benefits_benefitId) values (?1, ?2)",
	  nativeQuery = true)
	public void setRelation(Long coveragePlanId, int benefitId);

	@Query(value = 
		    "SELECT * FROM coverageplan where submissionId=?1",
		  nativeQuery = true)
	public CoveragePlan findBySubmissionId(Long userId);
	
}
