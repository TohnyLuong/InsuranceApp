package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Benefit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long benefitId;
	private String benefitName;
	private String description;
}
