package com.example.demo.util;

import com.example.demo.model.*;

import java.util.HashSet;
import java.util.Set;

public class RuleEngineUtil {

    public static Set<ClaimRule> evaluateRules(DamageClaim claim) {
        // Dummy logic
        return new HashSet<>();
    }

    public static Double calculateScore(Set<ClaimRule> rules) {
        return rules.size() * 10.0;
    }
}
