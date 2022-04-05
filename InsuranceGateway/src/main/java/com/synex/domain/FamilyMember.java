package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class FamilyMember {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long familyMemberId;
	private String firstName;
	private String lastName;
	private int age;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<MedicalCondition> medicalConditions = new ArrayList<>();
}
