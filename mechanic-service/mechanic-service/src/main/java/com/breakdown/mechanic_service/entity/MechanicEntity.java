package com.breakdown.mechanic_service.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mechanics")
public class MechanicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String phone;

    @Column(nullable=false)
    private String location;

    @Column(nullable=true)
    private boolean approved = false;

    @Column(nullable=true)
    private String role = "MECHANIC";
}
