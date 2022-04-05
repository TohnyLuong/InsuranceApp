package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.FamilyMember;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long>{
	
	@Transactional
	@Modifying
	@Query(
	  value = 
	    "insert into users_familymember (User_userId, familyMembers_familyMemberId) values (?1, ?2)",
	  nativeQuery = true)
	public void setRelation(Long userId, Long familyMemberId);
	
	
	@Query(value = 
		    "SELECT * FROM familymember ORDER BY familyMemberId DESC LIMIT 1",
		  nativeQuery = true)
	public FamilyMember fmLastIndex();
	
}
