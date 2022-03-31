package com.systemdesign.ticketstock.models;


import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    private Long id;

    @ManyToOne
    private User user;


    /***
     *  Need confirm ticket
     */
    @OneToOne
    private Ticket ticket;

    @Column
    private String status;

    @Column
    private String type;

    @Column
    private Long paymentId;
}
