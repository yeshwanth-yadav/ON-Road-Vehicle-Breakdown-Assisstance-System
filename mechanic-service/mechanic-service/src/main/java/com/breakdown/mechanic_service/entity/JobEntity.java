package com.breakdown.mechanic_service.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jobs")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="request_id", nullable=false)
    private Long requestId;

    @Column(name="mechanic_id", nullable=false)
    private Long mechanicId;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private JobStatus status = JobStatus.IN_PROGRESS;
}
