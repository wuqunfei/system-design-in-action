package com.systemdesign.ticketstock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_USER")
public class User {
    @Id
    private Long id;

    @Column
    private String userName;

    @Column
    private String email;
}
