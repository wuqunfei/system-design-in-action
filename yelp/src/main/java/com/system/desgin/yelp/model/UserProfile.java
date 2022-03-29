package com.system.desgin.yelp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UserProfile {
    @Id
    private UUID userId;
}
