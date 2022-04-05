package com.synex.restclient;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class InsurancePlanMicroService {

	public static final String insuranceMicroServiceURL = "http://localhost:8383/"; 
	
//	public List<String> findAll() {
//		System.out.println("InsuranceGateway - InsurancePlanMicroService - getAllBookings");
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Object> responseEntity = restTemplate.getForEntity(insuranceMicroServiceURL+"getAllBookings", Object.class);
//		
//		Object objects = responseEntity.getBody();
//		
//		ObjectMapper mapper = new ObjectMapper();
//		return mapper.convertValue(objects, List.class);
//	}
	
	public JsonNode saveEnrollmentPlan(@RequestBody JsonNode data) {
		System.out.println("InsuranceGateway - InsurancePlanMicroService - saveEnrollmentPlan");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>(data.toString(),headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(insuranceMicroServiceURL+"saveEnrollmentPlan", request, Object.class);
		
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}

	public JsonNode getEnrollmentPlanById(@RequestBody JsonNode data) {
		System.out.println("InsuranceGateway - InsurancePlanMicroService - getEnrollmentPlanById");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>(data.toString(),headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(insuranceMicroServiceURL+"getEnrollmentPlanById", request, Object.class);
		
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}

	public JsonNode paidEnrollmentPlan(@RequestBody JsonNode data) {
		System.out.println("InsuranceGateway - InsurancePlanMicroService - paidEnrollmentPlan");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>(data.toString(),headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(insuranceMicroServiceURL+"paidEnrollmentPlan", request, Object.class);
		
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}
	
}
