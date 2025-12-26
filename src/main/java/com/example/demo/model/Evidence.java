package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String data;

    @ManyToOne
    private DamageClaim claim;

    // 🔥 EXACT FIELD NAME REQUIRED
    private LocalDateTime uploadedAt;

    // 🔥 MUST BE @PrePersist
    @PrePersist
    protected void onCreate() {
        this.uploadedAt = LocalDateTime.now();
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public DamageClaim getClaim() {
        return claim;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setClaim(DamageClaim claim) {
        this.claim = claim;
    }

    // ⚠️ setter exists but DO NOT call it manually
    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
