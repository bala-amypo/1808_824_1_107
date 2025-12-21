package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "damage_claim")
public class DamageClaim {

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

    // Technical requirement for testing
    @ManyToMany
    @JoinTable(
        name = "damage_claim_rule",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<ClaimRule> appliedRules;

    // Auto-generate filedAt
    @PrePersist
    public void onCreate() {
        this.filedAt = LocalDateTime.now();
    }

    // Constructors
    public DamageClaim() {
    }

    public DamageClaim(Long id, Parcel parcel, String claimDescription,
                       ClaimStatus status, Double score, Set<ClaimRule> appliedRules) {
        this.id = id;
        this.parcel = parcel;
        this.claimDescription = claimDescription;
        this.status = status;
        this.score = score;
        this.appliedRules = appliedRules;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getFiledAt() {
        return filedAt;
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
    enum ClaimStatus {
    PENDING,
    APPROVED,
    REJECTED
}


}


