package com.example.demo.util;

import com.example.demo.model.ClaimRule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RuleEngineUtil {

    /**
     * Result wrapper expected by service layer
     */
    public static class Result {
        private double score;
        private Set<ClaimRule> appliedRules;

        public Result(double score, Set<ClaimRule> appliedRules) {
            this.score = score;
            this.appliedRules = appliedRules;
        }

        public double getScore() {
            return score;
        }

        public Set<ClaimRule> getAppliedRules() {
            return appliedRules;
        }
    }

    /* =========================================================
       ✅ METHODS EXPECTED BY TESTS
       ========================================================= */

    // Main method tests are calling
    public static double computeScore(String description, List<ClaimRule> rules) {
        return evaluate(description, rules).getScore();
    }

    // Overload used in some test cases
    public static double computeScore(String description, List<ClaimRule> rules) {
        if (rules == null) {
            return 0.0;
        }
        return computeScore(description, (List<ClaimRule>) rules);
    }

    // Null-safe overload used in tests
    public static double computeScore(Object description, List<ClaimRule> rules) {
        return computeScore(description == null ? "" : description.toString(), rules);
    }

    /* =========================================================
       CORE LOGIC
       ========================================================= */

    public static Result evaluate(String description, List<ClaimRule> rules) {

        double totalScore = 0.0;
        Set<ClaimRule> appliedRules = new HashSet<>();

        if (description == null || rules == null) {
            return new Result(0.0, appliedRules);
        }

        String lowerDesc = description.toLowerCase();

        for (ClaimRule rule : rules) {
            String condition = rule.getConditionExpression();

            if (matches(condition, lowerDesc)) {
                appliedRules.add(rule);
                totalScore += rule.getWeight();
            }
        }

        if (totalScore > 1.0) {
            totalScore = 1.0;
        }

        return new Result(totalScore, appliedRules);
    }

    private static boolean matches(String condition, String description) {

        if (condition == null) {
            return false;
        }

        if ("always".equalsIgnoreCase(condition)) {
            return true;
        }

        if (condition.toLowerCase().startsWith("description_contains:")) {
            String keyword = condition
                    .substring("description_contains:".length())
                    .toLowerCase();
            return description.contains(keyword);
        }

        return false;
    }
}
