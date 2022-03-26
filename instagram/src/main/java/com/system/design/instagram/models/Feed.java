package com.system.design.instagram.models;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.HashPartitioning;
import org.eclipse.persistence.annotations.Partitioned;

import java.io.Serializable;
import java.util.Date;

@Entity
@Partitioned("shardUserId")
@HashPartitioning(
        name = "shardUserId",
        partitionColumn = @Column(name = "userId"),
        unionUnpartitionableQueries = true)
@Table(name = "T_FEED") //Moving post data into feed, preparing data to user to pull
@IdClass(FeedClusterKey.class)
public class Feed {

    @Id
    private Long UserId;

    private Long authorId;
    @Id
    private Long postId;

    // No need to join the table (de-normalization)
    private String authorName;
    private String postURL;
    @Id
    private Date createTime;
}

class FeedClusterKey implements Serializable {
    //    Query where userId > createTime > postId order
    //    Cache pagination for next offset and limit
    private Long userId;
    private Date createTime;
    private Long postId;

    public FeedClusterKey(Long userId, Date createTime, Long postId) {
        this.userId = userId;
        this.createTime = createTime;
        this.postId = postId;
    }


}


