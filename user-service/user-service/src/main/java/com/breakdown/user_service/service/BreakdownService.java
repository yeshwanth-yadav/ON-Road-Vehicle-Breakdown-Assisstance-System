package com.breakdown.user_service.service;

import com.breakdown.user_service.entity.BreakdownRequestEntity;
import com.breakdown.user_service.entity.RequestStatus;
import com.breakdown.user_service.exception.BadRequestException;
import com.breakdown.user_service.exception.ResourceNotFoundException;
import com.breakdown.user_service.repository.BreakdownReqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreakdownService {

    @Autowired
    private BreakdownReqRepo reqRepo;

    public BreakdownRequestEntity createRequest(BreakdownRequestEntity request) {

        if (request == null) {
            throw new BadRequestException("Request cannot be null");
        }

        request.setStatus(RequestStatus.NEW);
        return reqRepo.save(request);
    }

    public List<BreakdownRequestEntity> getUserRequests(Long userId) {

        List<BreakdownRequestEntity> requests = reqRepo.findByUserId(userId);

        if (requests.isEmpty()) {
            throw new ResourceNotFoundException("No requests found for user id " + userId);
        }

        return requests;
    }

    public List<BreakdownRequestEntity> getAllRequests() {

        List<BreakdownRequestEntity> requests = reqRepo.findAll();

        if (requests.isEmpty()) {
            throw new ResourceNotFoundException("No breakdown requests found");
        }

        return requests;
    }

    public BreakdownRequestEntity updateStatus(Long requestId, RequestStatus status) {
        BreakdownRequestEntity requestEntity = reqRepo.findByid(requestId);
        requestEntity.setId(requestId);
        requestEntity.setStatus(status);
        return reqRepo.save(requestEntity);
    }

    public List<BreakdownRequestEntity> getNewRequests(RequestStatus status) {
        return reqRepo.findByStatus(status);
    }
}