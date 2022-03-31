package com.systemdesign.ticketstock.models;

import jakarta.persistence.*;

@Entity
@Table(name = "T_MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Long duration;
}
