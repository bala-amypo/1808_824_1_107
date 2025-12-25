package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ClaimRule;
import java.util.List;

public interface ClaimRuleRepository extends JpaRepository<ClaimRule, Long> {
    List<ClaimRule> findAll();
}
