package com.systemdesign.ticketstock.models;

import jakarta.persistence.*;

@Entity
@Table(name = "T_VENUE")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String type;

    @Column
    private String description;

    @Column
    private Long geoHash;

    @Column
    private String address;
}
