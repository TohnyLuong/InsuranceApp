package com.synex.services;

import java.util.List;

import com.synex.domain.FamilyMember;

public interface FamilyMemberService {

	public List<FamilyMember> findAll();
	public FamilyMember save(FamilyMember familyMembers);
	void setUserFMRelational(Long userId, Long familyMemberId);
	FamilyMember seeLastIndex();
	
}
