package com.system.desgin.instantmessaging.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;


import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import org.eclipse.persistence.annotations.HashPartitioning;
import org.eclipse.persistence.annotations.Partitioned;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;


/***
 * @HashPartitioning
 */
@Entity
@Partitioned("shardToUserId")
@HashPartitioning(
        name = "shardToUserId",
        partitionColumn = @Column(name = "toUserId"),
        unionUnpartitionableQueries = true)

@Table(name = "T_MESSAGE")
@IdClass(MessagePK.class)
public class Message implements Serializable {
    @Column
    private UUID messageUUID;

    @Id
    @Column
    private Long toUserId;

    @Id
    @Column
    private Timestamp timestamp;

    @Id
    @Column
    private Long fromUserId;

    @Column(length = 140)
    private String body;
}

/***
 *  Cluster Index in mysql called Primary Key
 */

class MessagePK implements Serializable{
    private final Long toUserId;
    private final Date timestamp;
    private final Long fromUserId;

    public MessagePK(Long toUserId, Date timestamp, Long fromUserId) {
        this.toUserId = toUserId;
        this.timestamp = timestamp;
        this.fromUserId = fromUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessagePK messageId = (MessagePK) o;
        return Objects.equals(toUserId, messageId.toUserId) && Objects.equals(timestamp, messageId.timestamp) && Objects.equals(fromUserId, messageId.fromUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toUserId, timestamp, fromUserId);
    }
}