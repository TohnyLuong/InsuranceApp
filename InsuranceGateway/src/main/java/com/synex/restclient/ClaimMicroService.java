package com.synex.restclient;

import java.io.File;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ClaimMicroService {

	public static final String insuranceMicroServiceURL = "http://localhost:8484/"; 

/*	
	public String uploadFiles(@RequestBody MultipartFile[] data) {
		System.out.println("InsuranceGateway - ClaimMicroService - uploadFiles");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>(data.toString(),headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(insuranceMicroServiceURL+"uploadFiles", request, Object.class);
		
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, String.class);
	}
*/
	
	public JsonNode uploadFiles(@RequestBody JsonNode data) {
		System.out.println("InsuranceGateway - ClaimMicroService - uploadFiles");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>(data.toString(),headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(insuranceMicroServiceURL+"uploadFiles", request, Object.class);
		
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}
	
	public JsonNode downloadFile(@RequestBody JsonNode data) {
		System.out.println("InsuranceGateway - ClaimMicroService - downloadFile");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>(data.toString(),headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(insuranceMicroServiceURL+"downloadFile", request, Object.class);
		
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}
	
}
