package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class HealthInfoSubmission {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long healthInfoId;
	private Long submissionId; // based on userid
	private String firstName;
	private String lastName;
//	@ManyToMany
//	private List<MedicalCondition> medicalConditions = new ArrayList<>();
}
