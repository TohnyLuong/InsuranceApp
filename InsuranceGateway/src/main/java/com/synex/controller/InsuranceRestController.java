package com.synex.controller;


import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.digester.EnvironmentPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synex.domain.FamilyMember;
import com.synex.domain.MedicalCondition;
import com.synex.domain.User;
import com.synex.restclient.ClaimMicroService;
import com.synex.restclient.InsurancePlanMicroService;
import com.synex.services.FamilyMemberService;
import com.synex.services.MedicalConditionService;
import com.synex.services.UserService;
import org.springframework.core.env.Environment;

@RestController
public class InsuranceRestController {

	@Autowired
	InsurancePlanMicroService insurancePlanMicroService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FamilyMemberService familyMemberService;
	
	@Autowired
	MedicalConditionService medicalConditionService;
	
	@Autowired
	ClaimMicroService claimMicroService;
	
	@Autowired
	private Environment env;
	
/*	//Save ENROLLED PLAN
	@PostMapping(value = "/insuranceGatewayUploadFileToClaim")
	public void insuranceGatewayUploadFileToClaim(@RequestParam("files") MultipartFile[] files) throws IOException {
	//public ResponseEntity<?> insuranceGatewayUploadFileToClaim(@RequestParam("files") MultipartFile[] files) throws IOException {
		System.out.println("From:insurance /insuranceGatewayUploadFileToClaim");
		

		for(int i=0; i<files.length; i++) {
			File convFile = new File(files[i].getOriginalFilename());
			System.out.println(convFile.getAbsolutePath());
			System.out.println(convFile.getCanonicalPath());
			System.out.println(files[i].getOriginalFilename());
			System.out.println(files[i].getContentType());
			System.out.println(files[i].getClass());
			System.out.println(files[i].getBytes()); // returns contents of the file as an array of bytes
			System.out.println(files[i].getInputStream().toString());
			System.out.println(files[i].getResource().getDescription());
			System.out.println(files[i].getResource().getFilename());
			//System.out.println(files[i].getResource().getURI().getRawPath());
			//System.out.println(files[i].getResource().getURI().toString());
			System.out.println();
		}
		//return new ResponseEntity<>(claimMicroService.uploadFiles(files),HttpStatus.OK);
	}
*/	
	//Upload files to claim
	@PostMapping(value = "/insuranceGatewayUploadFileToClaim")
	public String insuranceGatewayUploadFileToClaim(Model model, HttpServletResponse response, @RequestParam("files") MultipartFile[] files, Principal principal) throws IOException {
	//public ResponseEntity<?> insuranceGatewayUploadFileToClaim(@RequestParam("files") MultipartFile[] files) throws IOException {
		System.out.println("From:insurance /insuranceGatewayUploadFileToClaim");
		
		model.addAttribute("docs", files);
		
		JsonNode node = JsonNodeFactory.instance.objectNode();
		((ObjectNode) node)
			.put("numFiles", files.length);
		for(int i=0; i<files.length; i++) {
			((ObjectNode) node)
				.put("userId"+i, userService.findByUserName(principal.getName()).getUserId())
				.put("OGfileName"+i, files[i].getOriginalFilename())
				.put("contentType"+i, files[i].getContentType())
				.put("fileBytes"+i, files[i].getBytes());
		}
		System.out.println("node: "+node);
		claimMicroService.uploadFiles(node);
		response.sendRedirect("http://localhost:8282/insurance/gateway/claims");
		
		return "Uploaded!";
	}
	
	//Download files From claim
	@PostMapping(value = "/insuranceGatewayDownloadFileFromClaim/{data}")
	public JsonNode insuranceGatewayDownloadFileFromClaim(@PathVariable String data ) {
		System.out.println("From:insurance /insuranceGatewayDownloadFileFromClaim");
		
		Long userId = userService.findByUserName(data).getUserId();
		
		JsonNode node = JsonNodeFactory.instance.objectNode();

		((ObjectNode) node)
			.put("userId", userId);
		
		return claimMicroService.downloadFile(node);
	}
	
	//Save ENROLLED PLAN
	@PostMapping(value = "/insuranceGatewaysaveEnrollmentPlan")
	public JsonNode insuranceGatewaysaveEnrollmentPlan(@RequestBody JsonNode data) {
		System.out.println("From:insurance /insuranceGatewaysaveEnrollmentPlan");
		
		Long userId = userService.findByUserName(data.get("userName").asText()).getUserId();
		String planType = new String();
				if(data.get("urlPath").asText().toLowerCase().contains("basic")) {
					planType="Basic";
				} else if(data.get("urlPath").asText().toLowerCase().contains("pro")) {
					planType="Pro";
				} else if(data.get("urlPath").asText().toLowerCase().contains("premium")) {
					planType="Premium";
				}
		
		JsonNode node = JsonNodeFactory.instance.objectNode();

		((ObjectNode) node)
			.put("userId", userId)
			.put("planType", planType);
		
		return insurancePlanMicroService.saveEnrollmentPlan(node);
	}
	
	//getEnrolledPlan Data
	@PostMapping(value="/insuranceGatewaygetEnrollmentPlanByUserId")
	public JsonNode insuranceGatewaygetEnrollmentPlanByUserId(@RequestBody JsonNode data) {
	
		Long userId = userService.findByUserName(data.get("userName").asText().trim()).getUserId();
		
		JsonNode node = JsonNodeFactory.instance.objectNode();

		((ObjectNode) node)
			.put("userId", userId);
		
		return insurancePlanMicroService.getEnrollmentPlanById(node);
	}
	
	//PAID ENROLLED PLAN
	@PostMapping(value = "/insuranceGatewayPaidEnrollmentPlan")
	public JsonNode insuranceGatewayPaidEnrollmentPlan(@RequestBody JsonNode data) {
		System.out.println("From:insurance /insuranceGatewayPaidEnrollmentPlan");
		
		Long userId = userService.findByUserName(data.get("userName").asText()).getUserId();

		
		JsonNode node = JsonNodeFactory.instance.objectNode();

		((ObjectNode) node)
			.put("userId", userId);
		
		return insurancePlanMicroService.paidEnrollmentPlan(node);
	}
	
	@PostMapping(value="/checkIfExistingUserName")
	public User checkIfExistingUserName(@RequestBody JsonNode data) {
		System.out.println("check IfExistingUserName");
		System.out.println(data);
		User user = new User();
		user.setUserName(data.get("userName").asText());
		
		return userService.findByUserName(user.getUserName());
	}
	
	@PostMapping(value="/saveUser")
	public User saveUser(@RequestBody JsonNode data) {
		System.out.println("save User");
		System.out.println(data);
		User user = new User();
		user.setUserName(data.get("userName").asText());
		user.setUserPassword(data.get("userPassword").asText());
		user.setUserEmail(data.get("userEmail").asText().trim());
		user.setPhone(data.get("phone").asText());
		user.setAddress(
				data.get("country").asText(),
				data.get("addressLine").asText(),
				data.get("city").asText(),
				data.get("state").asText(),
				data.get("zipCode").asText()
				);
		
		return userService.save(user);
	}

	
	@PostMapping(value="/saveFamilyMember")
	public FamilyMember saveFamilyMember(@RequestBody JsonNode data) {
		System.out.println("save FamilyMember");
		System.out.println(data);
		FamilyMember familyMember = new FamilyMember();
		
		familyMember.setFirstName(data.get("firstName").asText());
		familyMember.setLastName(data.get("lastName").asText());
		familyMember.setAge(data.get("age").asInt());
		
		return familyMemberService.save(familyMember);
	}
	
	
	@PostMapping(value="/setUserAndFamilyMemberRelation")
	public Boolean  setUserAndFamilyMemberRelation(@RequestBody JsonNode data) {
		System.out.println("set UserAndFamilyMemberRelation");
		System.out.println(data);
		
		Long userId = userService.findByUserName(data.get("userName").asText()).getUserId();
		int fmSize = data.get("familyMemberSize").asInt();
		
//		FamilyMember familyMember = new FamilyMember();
//		User user = new User();
		
		Long fmId = familyMemberService.seeLastIndex().getFamilyMemberId();
		System.out.println(familyMemberService.seeLastIndex());
		
		
		System.out.println("last indexed fmID: "+fmId+"  UserID:"+userId);
		
		for(int i=0; i<fmSize; i++) {
			familyMemberService.setUserFMRelational(userId, fmId-i);
		}
		
		if(data !=null)
			return true;
		
		return false;
	}
	
	@PostMapping(value = "/showUserAndFM")
	public User showUserAndFM(@RequestBody JsonNode data) {
		System.out.println("From:InsuranceGateway /showUserAndFM");
		//System.out.println(data.get("userName").asText().trim());
		String name = data.get("userName").asText().trim();
		System.out.println(userService.findByUserName(name));
		return userService.findByUserName(name);
	}
	
	@PostMapping(value = "/setFMmedCondition")
	public User setFMmedCondition(@RequestBody JsonNode data) {
		System.out.println("From:InsuranceGateway /setFMmedCondition");
		//System.out.println(data.get("userName").asText().trim());
		String name = data.get("userName").asText().trim();
		String dataURL = data.get("url").toString();
		String dataURLpath =data.get("urlPath").toString();
		String dataURLParams =data.get("urlParams").toString();
		int fmSize = data.get("familyMemberSize").asInt();
		//System.out.println(userService.findByUserName(name));
		System.out.println("setFMmedCondition url: "+dataURL);
		System.out.println("setFMmedCondition url Path: "+dataURLpath);
		//System.out.println("setFMmedCondition url Params: "+dataURLParams.contains("scales"));
		
		for(int i=1; i<=fmSize; i++) {
			
			//---------Acne
			if(dataURLParams.contains("fm"+i+"MC"+"Acne")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Acne");
				medCon.setSeverityLevel(1);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}
			
			//----------Addison's disease
			if(dataURLParams.contains("fm"+i+"MC"+"Addisonsdisease")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Addison's disease");
				medCon.setSeverityLevel(4);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}
			
			//----------Alcohol-related liver disease
			if(dataURLParams.contains("fm"+i+"MC"+"Alcoholrelatedliverdisease")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Alcohol-related liver disease");
				medCon.setSeverityLevel(3);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}
			
			//----------Allergies
			if(dataURLParams.contains("fm"+i+"MC"+"Allergies")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Allergies");
				medCon.setSeverityLevel(1);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}
			
			//----------Bone cancer
			if(dataURLParams.contains("fm"+i+"MC"+"Bonecancer")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Bone cancer");
				medCon.setSeverityLevel(4);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}
			
			//----------Chest pain
			if(dataURLParams.contains("fm"+i+"MC"+"Chestpain")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Chest pain");
				medCon.setSeverityLevel(1);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}

			//----------Cold Sore
			if(dataURLParams.contains("fm"+i+"MC"+"ColdSore")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Cold Sore");
				medCon.setSeverityLevel(1);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}
			
			//----------Cough
			if(dataURLParams.contains("fm"+i+"MC"+"Cough")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Cough");
				medCon.setSeverityLevel(1);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}

			//----------Dementia
			if(dataURLParams.contains("fm"+i+"MC"+"Dementia")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Dementia");
				medCon.setSeverityLevel(3);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}
			

			//----------Diabetes
			if(dataURLParams.contains("fm"+i+"MC"+"Diabetes")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Diabetes");
				medCon.setSeverityLevel(2);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}

			//----------Flu
			if(dataURLParams.contains("fm"+i+"MC"+"Flu")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Flu");
				medCon.setSeverityLevel(1);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}
			

			//----------Hepatitis
			if(dataURLParams.contains("fm"+i+"MC"+"Hepatitis")) {
				MedicalCondition medCon= new MedicalCondition();
				medCon.setConditionName("Hepatitis");
				medCon.setSeverityLevel(3);
				medicalConditionService.save(medCon);
				
				Long medConId = medCon.getMedicalConditionId();
				Long fmId = userService.findByUserName(name).getFamilyMembers().get(i-1).getFamilyMemberId();
				
				medicalConditionService.setFMAndMedConRelational(fmId, medConId);
			}
		}
		
		
		return userService.findByUserName(name);
	}
	
}
