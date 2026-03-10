package com.breakdown.mechanic_service.repository;

import com.breakdown.mechanic_service.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepo extends JpaRepository<JobEntity,Long> {
    List<JobEntity> findByMechanicId(Long mechanicId);
}
