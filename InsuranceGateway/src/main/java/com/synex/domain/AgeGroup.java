package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AgeGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ageGroupId;
	private String name;
	private String ageRange;
	//private double discount;
}
