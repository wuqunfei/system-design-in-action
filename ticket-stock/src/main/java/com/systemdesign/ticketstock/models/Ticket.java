package com.systemdesign.ticketstock.models;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.HashPartitioning;
import org.eclipse.persistence.annotations.Partitioned;

import java.sql.Date;

@Entity
@Table(name = "T_TICKET")

@Partitioned("shardEventId")
@HashPartitioning(
        name = "shardEventId",
        partitionColumn = @Column(name = "event_id"),
        unionUnpartitionableQueries = true)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    /**
     *  Sharding key
     */
    @Column(name = "event_id")
    private Long eventId;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

    @Column
    private Integer row;

    @Column
    private Integer column;

    @Column
    private Integer price;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Column
    private Date modifiedTime;
}

/***
 * Ticket status, when click select action, the status is pending for limited time windows like 10 minutes.
 */
enum TicketStatus{
    AVAILABLE,
    NOT_AVAILABLE,
    PENDING
}