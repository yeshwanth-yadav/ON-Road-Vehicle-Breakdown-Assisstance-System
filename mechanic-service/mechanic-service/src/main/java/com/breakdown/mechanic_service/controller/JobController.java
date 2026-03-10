package com.breakdown.mechanic_service.controller;

import com.breakdown.mechanic_service.entity.JobEntity;
import com.breakdown.mechanic_service.entity.JobStatus;
import com.breakdown.mechanic_service.entity.MechanicEntity;
import com.breakdown.mechanic_service.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @PutMapping("/assign")
    public ResponseEntity<JobEntity> assignJob(@RequestParam Long requestId, @RequestParam Long mechanicId) {
        JobEntity job = jobService.assignJob(requestId, mechanicId);
        return ResponseEntity.ok(job);
    }

    @PutMapping("/status")
    public ResponseEntity<JobEntity> updateStatus(@RequestParam Long jobId, @RequestParam JobStatus status) {
        JobEntity jobEntity = jobService.updateJobStatus(jobId, status);
        return ResponseEntity.ok(jobEntity);
    }

    @GetMapping("/mechanic/{mechanicId}")
    public ResponseEntity<List<JobEntity>> getJobs(@PathVariable Long mechanicId) {
        List<JobEntity> jobs = jobService.getJobsByMechanic(mechanicId);
        return ResponseEntity.ok(jobs);
    }

}
