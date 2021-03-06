package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.domain.CoveragePlan;
import com.synex.services.InsurancePlanServices;

@RestController
public class InsurancePlanRestController {

	@Autowired
	private InsurancePlanServices insurancePlanServices;
	
	@PostMapping(value="/saveEnrollmentPlan")
	public JsonNode saveEnrollment(@RequestBody JsonNode data) {
		System.out.println("save Enrollment Plan");
		System.out.println(data);
		CoveragePlan coveragePlan = new CoveragePlan();
		
		Long userid=data.get("userId").asLong();
		coveragePlan.setSubmissionId(userid);
		
		String planType = data.get("planType").asText();
		
		if(planType.contains("Basic")){
			coveragePlan.setCoverageTier(planType);
			coveragePlan.setPremium("Primary Care: $20");
			coveragePlan.setDeductable(2500);
			coveragePlan.setPurchaseStatus("Awaiting Payment");
			insurancePlanServices.saveCoveragePlan(coveragePlan);
			insurancePlanServices.setCovPlanIdToBenIdRelation(coveragePlan.getCoverageTierId(), 1);
		}
		else if(planType.contains("Pro")){
			coveragePlan.setCoverageTier(planType);
			coveragePlan.setPremium("Primary Care: $25/50% Coinsurance after deductible");
			coveragePlan.setDeductable(800);
			coveragePlan.setPurchaseStatus("Awaiting Payment");
			insurancePlanServices.saveCoveragePlan(coveragePlan);
			insurancePlanServices.setCovPlanIdToBenIdRelation(coveragePlan.getCoverageTierId(), 5);
		}
		else if(planType.contains("Premium")){
			coveragePlan.setCoverageTier(planType);
			coveragePlan.setPremium("Primary Care: $10");
			coveragePlan.setDeductable(1000);
			coveragePlan.setPurchaseStatus("Awaiting Payment");
			insurancePlanServices.saveCoveragePlan(coveragePlan);
			insurancePlanServices.setCovPlanIdToBenIdRelation(coveragePlan.getCoverageTierId(), 9);
		}
		
		return data;
	}
	
	@PostMapping(value="/getEnrollmentPlanById")
	public CoveragePlan getEnrollmentPlanById(@RequestBody JsonNode data) {
		System.out.println("getEnrollmentPlanById");
		System.out.println(data);
		CoveragePlan coveragePlan = new CoveragePlan();
		
		Long userid=data.get("userId").asLong();
		//System.out.println("getEnrollmentPlanById "+userid);

		return insurancePlanServices.getEnrollmentPlanByUserId(userid);
	}
	
	@PostMapping(value="/paidEnrollmentPlan")
	public CoveragePlan paidEnrollmentPlan(@RequestBody JsonNode data) {
		System.out.println("paidEnrollmentPlan");
		System.out.println(data);
		Long userid=data.get("userId").asLong();
		CoveragePlan coveragePlan = insurancePlanServices.getEnrollmentPlanByUserId(userid);
		coveragePlan.setPurchaseStatus("Paid");
		
		//System.out.println("getEnrollmentPlanById "+userid);

		return insurancePlanServices.updatePaymentByUserId(userid,coveragePlan);
	}
	
}
