package com.synex.services;

import com.synex.domain.MedicalCondition;

public interface MedicalConditionService {

	public MedicalCondition save(MedicalCondition medicalCondition);

	void setFMAndMedConRelational(Long familyMemberId, Long medicalConditionId);
	
}
