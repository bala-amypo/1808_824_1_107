package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import java.util.List;

@RestController
public class ClaimRuleController{
    @Autowired
    ClaimRuleService crs;
    @PostMapping("/rules")
    public ClaimRule rules(@RequestBody ClaimRule rule)
    {
        return crs.addRule(rule);
    }
    @GetMapping
    public List<ClaimRule> getrules()
    {
        return crs.getAllRules();
    }

}
