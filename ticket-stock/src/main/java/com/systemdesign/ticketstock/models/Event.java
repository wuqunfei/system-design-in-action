package com.systemdesign.ticketstock.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "T_EVENT")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Venue venue;

    @Column
    private String name;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Column
    private String status;


}
