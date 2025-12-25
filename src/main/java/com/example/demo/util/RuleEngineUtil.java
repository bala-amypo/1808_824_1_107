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

    /**
     * Evaluates claim description against rules
     */
    public static Result evaluate(String description, List<ClaimRule> rules) {

        double totalScore = 0.0;
        Set<ClaimRule> appliedRules = new HashSet<>();

        if (description == null) {
            description = "";
        }

        String lowerDesc = description.toLowerCase();

        for (ClaimRule rule : rules) {
            String condition = rule.getConditionExpression();

            if (matches(condition, lowerDesc)) {
                appliedRules.add(rule);
                totalScore += rule.getWeight();
            }
        }

        // Clamp score between 0.0 and 1.0
        if (totalScore > 1.0) {
            totalScore = 1.0;
        }

        return new Result(totalScore, appliedRules);
    }

    /**
     * Rule matching logic
     */
    private static boolean matches(String condition, String description) {

        if (condition == null) {
            return false;
        }

        // Rule: always
        if ("always".equalsIgnoreCase(condition)) {
            return true;
        }

        // Rule: description_contains:KEYWORD
        if (condition.toLowerCase().startsWith("description_contains:")) {
            String keyword = condition.substring("description_contains:".length())
                    .toLowerCase();
            return description.contains(keyword);
        }

        return false;
    }
}
