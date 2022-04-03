package com.example.cloudstorage.services.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Namespace {
    @Id
    private Long namespaceId;
    private String namespace;
    private Long ownerId;
}
