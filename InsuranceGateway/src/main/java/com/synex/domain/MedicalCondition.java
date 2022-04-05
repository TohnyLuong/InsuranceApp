package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MedicalCondition {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long medicalConditionId;
	private String conditionName; 
	//private String description; //??
	private int severityLevel; // levels 1 to 4
}
