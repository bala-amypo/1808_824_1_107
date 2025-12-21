package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final DamageClaimRepository damageClaimRepository;
    private final ParcelRepository parcelRepository;

    public DamageClaimServiceImpl(DamageClaimRepository damageClaimRepository,
                                  ParcelRepository parcelRepository) {
        this.damageClaimRepository = damageClaimRepository;
        this.parcelRepository = parcelRepository;
    }

    /**
     * File a claim after checking parcel exists
     */
    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {

        Parcel parcel = parcelRepository.findById(parcelId)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));

        claim.setParcel(parcel);
        claim.setStatus(ClaimStatus.PENDING);

        return damageClaimRepository.save(claim);
    }

    /**
     * Evaluate claim using RuleEngineUtil and update score & status
     */
    @Override
    public DamageClaim evaluateClaim(Long claimId) {

        DamageClaim claim = damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        // Evaluate rules
        Set<ClaimRule> appliedRules = RuleEngineUtil.evaluateRules(claim);

        Double score = RuleEngineUtil.calculateScore(appliedRules);

        claim.setAppliedRules(appliedRules);
        claim.setScore(score);

        // Update status AFTER evaluation
        if (score >= 70) {
            claim.setStatus(ClaimStatus.APPROVED);
        } else {
            claim.setStatus(ClaimStatus.REJECTED);
        }

        return damageClaimRepository.save(claim);
    }

    /**
     * Get claim by ID
     */
    @Override
    public DamageClaim getClaim(Long claimId) {
        return damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }
}
