package com.system.desgin.instantmessaging.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.persistence.annotations.HashPartitioning;
import org.eclipse.persistence.annotations.Partitioned;

import java.sql.Timestamp;

@Entity
@Partitioned("shardUserId")
@HashPartitioning(
        name = "shardUserId",
        partitionColumn = @Column(name = "userId"),
        unionUnpartitionableQueries = true)

@Table(name = "T_Presence")
public class PresenceStatus {
    @Id
    private Long userId;
    @Column
    private Timestamp lastTimestamp;
    @Column
    private String socketSessionId;
}
