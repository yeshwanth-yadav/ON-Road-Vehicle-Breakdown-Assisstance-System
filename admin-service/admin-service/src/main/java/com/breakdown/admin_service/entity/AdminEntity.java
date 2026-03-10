package com.breakdown.admin_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admins")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String role;
}