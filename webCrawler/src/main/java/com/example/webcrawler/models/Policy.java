package com.example.webcrawler.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Policy {
    @Id
    private UUID policyId;

    @Column
    private String domain;

    @Column
    private Integer concurrency;

    @Column
    private Integer latency;

    @Column
    private Integer startDelay;

    @Column
    private Integer afterDelay;


    public Integer getThrottling() {
        return this.latency / this.concurrency;
    }
}
