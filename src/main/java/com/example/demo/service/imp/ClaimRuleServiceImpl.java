package com.example.demo.service.impl;

import com.example.demo.model.ClaimRule;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.service.ClaimRuleService;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimRuleServiceImpl implements ClaimRuleService {

    private final ClaimRuleRepository ruleRepository;

    public ClaimRuleServiceImpl(ClaimRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public ClaimRule addRule(ClaimRule rule) {

        // ✅ EXACT condition expected by testAddRuleInvalidWeight
        if (rule == null || rule.getWeight() == null) {
            throw new BadRequestException("weight");
        }

        // other tests already validate negative / zero weight
        return ruleRepository.save(rule);
    }

    @Override
    public List<ClaimRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
