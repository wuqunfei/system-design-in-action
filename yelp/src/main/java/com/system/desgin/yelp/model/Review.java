package com.system.desgin.yelp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Review {
    @Id
    private UUID reviewId;
    private UUID businessId; // Partition/Shared Key

    private String content;
    private UUID authorId;

}
