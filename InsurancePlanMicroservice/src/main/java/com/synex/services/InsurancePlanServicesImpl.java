package com.synex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.domain.CoveragePlan;
import com.synex.repository.CoveragePlanRepository;

@Component
public class InsurancePlanServicesImpl implements InsurancePlanServices {

	@Autowired
	CoveragePlanRepository coveragePlanRepository;
	
	@Override
	public CoveragePlan findCoveragePlanById(int coverageTierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoveragePlan saveCoveragePlan(CoveragePlan coveragePlan) {
		return coveragePlanRepository.save(coveragePlan);
	}

	@Override
	public void setCovPlanIdToBenIdRelation(Long coveragePlanId, int index) {
		for(int i=index; i<index+4; i++) {
			coveragePlanRepository.setRelation(coveragePlanId, i);
		}
	}

	@Override
	public CoveragePlan getEnrollmentPlanByUserId(Long userid) {
		return coveragePlanRepository.findBySubmissionId(userid);
	}

	@Override
	public CoveragePlan updatePaymentByUserId(Long userid, CoveragePlan coveragePlan) {
		
		CoveragePlan coverage = coveragePlanRepository.findBySubmissionId(userid);
		coverage.setPurchaseStatus(coveragePlan.getPurchaseStatus());
		return coveragePlanRepository.save(coverage);
	}

	

}
