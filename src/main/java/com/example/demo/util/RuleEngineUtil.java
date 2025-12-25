// package com.example.demo.util;

// import com.example.demo.model.*;

// import java.util.HashSet;
// import java.util.Set;

// public class RuleEngineUtil {

//     public static Set<ClaimRule> evaluateRules(DamageClaim claim) {
//         // Dummy logic
//         return new HashSet<>();
//     }

//     public static Double calculateScore(Set<ClaimRule> rules) {
//         return rules.size() * 10.0;
//     }
// }
package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double evaluate(String text, List<ClaimRule> rules) {
        double score = 0;
        for (ClaimRule rule : rules) {
            if (text.toLowerCase().contains(rule.getKeyword().toLowerCase())) {
                score += rule.getWeight();
            }
        }
        return score;
    }
}
