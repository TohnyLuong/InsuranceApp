package com.synex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.FamilyMember;
import com.synex.repository.FamilyMemberRepository;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

	@Autowired
	FamilyMemberRepository familyMemberRepository;
	
	@Override
	public List<FamilyMember> findAll() {
		return familyMemberRepository.findAll();
	}

	@Override
	public FamilyMember save(FamilyMember familyMembers) {
		return familyMemberRepository.save(familyMembers);
	}

	@Override
	public void setUserFMRelational(Long userId, Long familyMemberId) {
		familyMemberRepository.setRelation(userId, familyMemberId);
	}
	
	@Override
	public FamilyMember seeLastIndex() {
		return familyMemberRepository.fmLastIndex();
	}
	
}
