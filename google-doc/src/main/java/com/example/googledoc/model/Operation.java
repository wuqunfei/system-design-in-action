package com.example.googledoc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity
public class Operation {

    @Id
    private Long operationId;

    @Column
    private Long documentId;

    @Column
    private Long baseVersion;

    @Column
    private List<OperationType> operations;

    @Column
    private Date timestamp;
}

class OperationType{
    String type;
    Long position;
    char a;
}