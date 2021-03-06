package com.synex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.MedicalCondition;
import com.synex.repository.MedicalConditionRepository;

@Service
public class MedicalConditionServiceImpl implements MedicalConditionService {

	@Autowired
	MedicalConditionRepository medicalConditionRepository;
	
	@Override
	public MedicalCondition save(MedicalCondition medicalCondition) {
		return medicalConditionRepository.save(medicalCondition);
	}

	@Override
	public void setFMAndMedConRelational(Long familyMemberId, Long medicalConditionId) {
		medicalConditionRepository.setRelation(familyMemberId, medicalConditionId);
	}
	
}
