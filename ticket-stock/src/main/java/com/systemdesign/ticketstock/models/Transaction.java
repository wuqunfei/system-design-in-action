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

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column
    private Long paymentId;

    /**
     * Linked to origin or related transaction id for refund or other operations
     */
    @Column
    private Long linkedTransactionId;
}

enum TransactionStatus{
    SUCCESS,
    FAILED,
    PENDING // when customer is paying
}

enum TransactionType{
    PAYMENT,
    REFUND
}