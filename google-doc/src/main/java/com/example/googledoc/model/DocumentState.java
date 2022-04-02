package com.example.googledoc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DocumentState {
    @Id
    private Long documentId;

    @Column
    private String content;
}
