package com.system.design.instagram.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.eclipse.persistence.annotations.HashPartitioning;
import org.eclipse.persistence.annotations.Partitioned;

import java.sql.Date;
import java.util.UUID;

@Entity
@Partitioned("shardAuthorId")
@HashPartitioning(
        name = "shardAuthorId",
        partitionColumn = @Column(name = "authorId"),
        unionUnpartitionableQueries = true)

@Table(name = "T_POST")
public class Post {
    @Id
    public UUID postId;
    @Column
    public Long authorId; //Sharding key
    @Column
    public Date createTime;
    @Column
    public String photoURL; //Object Storage URL address
    @Column
    boolean isCelebrity;

    // is celerity can be pre-cache feed
}


