package com.breakdown.mechanic_service.repository;

import com.breakdown.mechanic_service.entity.MechanicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MechanicRepo extends JpaRepository<MechanicEntity,Long> {
    Optional<MechanicEntity> findByEmail(String email);
}
