package com.breakdown.user_service.repository;
import com.breakdown.user_service.entity.BreakdownRequestEntity;
import com.breakdown.user_service.entity.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreakdownReqRepo extends JpaRepository<BreakdownRequestEntity, Long> {
    List<BreakdownRequestEntity> findByUserId(Long userId);
    BreakdownRequestEntity findByid(Long id);

    List<BreakdownRequestEntity> findByStatus(RequestStatus status);
}

