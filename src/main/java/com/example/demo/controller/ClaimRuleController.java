package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;

@RestController
public class ClaimRuleController{
    @Autowired
    ClaimRuleService crs;
    @PostMapping("/rules")
    public ClaimRule rules(@RequestBody ClaimRule rule)
    {
        return crs.addrule(rule);
    }
    @GetMapping
    public List<ClaimRule> getrules()
    {
        return crs.getAllrules()
    }

}
