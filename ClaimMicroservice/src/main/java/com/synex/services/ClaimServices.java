package com.synex.services;

import java.util.List;

import com.synex.domain.Claim;

public interface ClaimServices {

	public Claim save(Claim claim);
	
	public Claim getClaimById(Long submissionId);
	
	public List<Claim> getClaims();

	void setClaimAndDocRelational(Long claimId, Long documentId);
}
