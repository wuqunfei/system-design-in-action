package com.systemdesign.gissystem.model;

import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Trip {

    private UUID tripId;
    private Long driverId;
    private int status;

}

