package com.breakdown.admin_service.repository;

import com.breakdown.admin_service.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<AdminEntity,Long> {
    Optional<AdminEntity> findByEmail(String email);
}
