package com.systemdesign.ticketstock.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "T_TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer row;

    @Column
    private Integer column;

    @Column
    private Integer price;

    @Column
    private String status;

    @Column
    private Date updateTime;
}