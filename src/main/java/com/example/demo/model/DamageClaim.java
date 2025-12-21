package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "damage_claim")
public class DamageClaim {

    // ✅ Enum inside entity
    public enum ClaimStatus {
        PENDING,
        APPROVED,
        REJECTED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;

    private String claimDescription;

    private LocalDateTime filedAt;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;

    private Double score;

    @ManyToMany
    @JoinTable(
        name = "damage_claim_rule",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<ClaimRule> appliedRules;

    @PrePersist
    public void onCreate() {
        this.filedAt = LocalDateTime.now();
    }

    // Constructors
    public DamageClaim() {}

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Set<ClaimRule> getAppliedRules() {
        return appliedRules;
    }

    public void setAppliedRules(Set<ClaimRule> appliedRules) {
        this.appliedRules = appliedRules;
    }
}
