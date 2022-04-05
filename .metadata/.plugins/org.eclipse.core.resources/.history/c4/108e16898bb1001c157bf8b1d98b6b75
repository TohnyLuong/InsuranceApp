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
public class CoveragePlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long coverageTierId; 
	private long submissionId; //user ID
	private String coverageTier; //basic, pro, premium
	private String premium;
	private double deductable;
	private String purchaseStatus; //"Awaiting Payment" or Paid
	@ManyToMany
	private List<Benefit> benefits = new ArrayList<>();
}

