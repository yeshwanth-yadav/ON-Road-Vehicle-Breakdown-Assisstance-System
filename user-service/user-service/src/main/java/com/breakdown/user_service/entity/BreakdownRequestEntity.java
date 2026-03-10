package com.breakdown.user_service.entity;


 import jakarta.persistence.*;
 import lombok.Data;

    @Data
    @Entity
    @Table(name = "breakdown_requests")
    public class BreakdownRequestEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "user_id", nullable = false)
        private Long userId;

        @Column(name = "vehicle_type", nullable = false)
        private String vehicleType;

        @Column(name = "problem_description", nullable = false)
        private String problemDescription;

        @Column(nullable = false)
        private String location;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private RequestStatus status = RequestStatus.NEW;

    }


