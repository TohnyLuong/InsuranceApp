package com.synex.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class PersonalInfoSubmission {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long personalInfoId;
	private Long submissionId; // userid
	private String firstName;
	private String lastName;
//	@Embedded
//	private Address address;
//	@ManyToOne
//	private AgeGroup ageGroup;
	
	//if have time, go back and move all address,family members,medical conditions back to InsurancePlanMicroService
}