package com.example.demo.service.imp;

import com.example.demo.model.*;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

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

    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {

        Parcel parcel = parcelRepository.findById(parcelId)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));

        claim.setParcel(parcel);
        claim.setStatus(ClaimStatus.PENDING);

        return damageClaimRepository.save(claim);
    }

    @Override
    public DamageClaim evaluateClaim(Long claimId) {

        DamageClaim claim = damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        Set<ClaimRule> rules = RuleEngineUtil.evaluateRules(claim);
        Double score = RuleEngineUtil.calculateScore(rules);

        claim.setAppliedRules(rules);
        claim.setScore(score);

        claim.setStatus(score >= 70 ? ClaimStatus.APPROVED : ClaimStatus.REJECTED);

        return damageClaimRepository.save(claim);
    }

    @Override
    public DamageClaim getClaim(Long claimId) {
        return damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }
}
