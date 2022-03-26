package com.system.design.instagram.models;

import jakarta.persistence.Entity;

@Entity
public class Follow {
    private Long userId;
    private Long followerId;

    //followerId follows userId
}
