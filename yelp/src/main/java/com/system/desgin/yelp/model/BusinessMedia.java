package com.system.desgin.yelp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity

public class BusinessMedia {
    @Id
    private UUID mediaId;
    private UUID businessId;
    private String mediaURL;
}
