package com.systemdesign.ticketstock.models;


import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    private Long id;

    @ManyToOne
    private User user;


    /***
     *  Need confirm ticket, distribution case
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

enum TransactionStatus {
    SUCCESS,
    FAILED,
    PENDING // when customer is paying
}

enum TransactionType {
    PAYMENT,
    REFUND
}

/***
 * https://developer.ibm.com/articles/use-saga-to-solve-distributed-transaction-management-problems-in-a-microservices-architecture/
 * https://developers.redhat.com/blog/2018/10/01/patterns-for-distributed-transactions-within-a-microservices-architecture#possible_solutions
 * https://www.zuehlke.com/en/insights/design-for-failure-distributed-transactions-in-microservices
 * https://www.vinsguru.com/orchestration-saga-pattern-with-spring-boot/
 * https://www.baeldung.com/java-atomikos
 * https://www.baeldung.com/java-reactive-systems
 ***/