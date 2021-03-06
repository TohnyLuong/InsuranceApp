package com.synex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Claim;
import com.synex.repository.ClaimRepository;

@Service
public class ClaimServicesImpl implements ClaimServices {

	@Autowired
	ClaimRepository claimRepository;
	
	@Override
	public Claim save(Claim claim) {
		return claimRepository.save(claim);
	}

	@Override
	public Claim getClaimById(Long submissionId) {
		return claimRepository.findBySubmissionId(submissionId);
	}
	
	@Override
	public void setClaimAndDocRelational(Long claimId, Long documentId) {
		claimRepository.setRelation(claimId, documentId);
	}

	@Override
	public List<Claim> getClaims() {
		// TODO Auto-generated method stub
		return null;
	}

}
