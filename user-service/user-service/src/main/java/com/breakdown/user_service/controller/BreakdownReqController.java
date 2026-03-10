package com.breakdown.user_service.controller;

import com.breakdown.user_service.entity.BreakdownRequestEntity;
import com.breakdown.user_service.entity.RequestStatus;
import com.breakdown.user_service.service.BreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/requests")
public class BreakdownReqController {

    @Autowired
    private BreakdownService breakdownService;

    @PostMapping
    public BreakdownRequestEntity create(@RequestBody BreakdownRequestEntity request) {
        return breakdownService.createRequest(request);
    }

    @GetMapping("/{userId}")
    public List<BreakdownRequestEntity> getUserRequests(@PathVariable Long userId) {
        return breakdownService.getUserRequests(userId);
    }

    @GetMapping("/new")
    public List<BreakdownRequestEntity> getNewRequests(@RequestParam RequestStatus status) {
        return breakdownService.getNewRequests(status);
    }

    @GetMapping
    public List<BreakdownRequestEntity> getAllRequests() {
        return breakdownService.getAllRequests();
    }

    @PutMapping("/{requestId}/status")
    public BreakdownRequestEntity updateStatus(
            @PathVariable Long requestId,
            @RequestParam("status") RequestStatus status) {

        return breakdownService.updateStatus(requestId, status);
    }
}
