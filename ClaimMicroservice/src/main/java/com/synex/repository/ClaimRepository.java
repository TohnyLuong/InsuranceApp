package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long>{

	@Transactional
	@Modifying
	@Query(
	  value = 
	    "insert into claim_document (Claim_id, documents_id) values (?1, ?2)",
	  nativeQuery = true)
	public void setRelation(Long claimId, Long documentId);
	
	
	@Query(value = 
		    "SELECT * FROM claim where submissionId=?1",
		  nativeQuery = true)
	public Claim findBySubmissionId(Long userId);
	
}
