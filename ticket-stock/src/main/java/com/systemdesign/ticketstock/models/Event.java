package com.systemdesign.ticketstock.models;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.Partitioned;
import org.eclipse.persistence.annotations.RangePartition;
import org.eclipse.persistence.annotations.RangePartitioning;

import java.sql.Date;

@Entity
@Table(name = "T_EVENT")
@Partitioned("shardGeoHash")
@RangePartitioning(
        name = "shardGeoHash",
        partitionColumn = @Column(name = "geoHash"),
        partitions = {
                @RangePartition(connectionPool = "", startValue = "", endValue = ""),
                @RangePartition(connectionPool = "", startValue = "", endValue = "")
        }, //To define the Range Partitions
        unionUnpartitionableQueries = true)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Venue venue;

    /***
     *  based on the venue location as sharding key
     */
    @Column
    private Long geoHash;

    @Column
    private String name;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Column
    private String status;


}
