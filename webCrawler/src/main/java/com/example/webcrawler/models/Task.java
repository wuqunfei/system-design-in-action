package com.example.webcrawler.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Task {
    @Id
    private UUID urlID;

    @Column
    private String URL;

    @Column
    private UUID domainId;

    @Column
    private Date lastCrawlTS;


}
