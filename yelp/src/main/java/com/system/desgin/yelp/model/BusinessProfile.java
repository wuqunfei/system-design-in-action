package com.system.desgin.yelp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class BusinessProfile {
    @Id
    private UUID businessId;

    private String businessName;

    @Id
    private Long s2CellId; //Partition Shard Key

    private String addressName;
}
