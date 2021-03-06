package com.synex.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.domain.CoveragePlan;

public interface InsurancePlanServices {

	public CoveragePlan findCoveragePlanById(int coverageTierId);
	
	public CoveragePlan saveCoveragePlan(CoveragePlan coveragePlan);
	
	public void setCovPlanIdToBenIdRelation(Long coveragePlanId, int index);

	public CoveragePlan getEnrollmentPlanByUserId(Long userid);

	public CoveragePlan updatePaymentByUserId(Long userid, CoveragePlan coveragePlan);
}
