package com.breakdown.mechanic_service.service;

import com.breakdown.mechanic_service.entity.JobEntity;
import com.breakdown.mechanic_service.entity.JobStatus;
import com.breakdown.mechanic_service.exception.BadRequestException;
import com.breakdown.mechanic_service.exception.ResourceNotFoundException;
import com.breakdown.mechanic_service.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepository;
    @Autowired
    private FetchRequestService fetchRequestService;

    public JobEntity assignJob(Long requestId, Long mechanicId) {

        if(requestId == null || mechanicId == null){
            throw new BadRequestException("RequestId and MechanicId are required");
        }

        JobEntity job = new JobEntity();
        job.setRequestId(requestId);
        job.setMechanicId(mechanicId);
        fetchRequestService.updateRequestStatus(requestId);

        return jobRepository.save(job);

    }

    public JobEntity updateJobStatus(Long jobId, JobStatus status) {

        JobEntity job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id " + jobId));

        if(status == null){
            throw new BadRequestException("Job status cannot be null");
        }

        job.setStatus(status);
        return jobRepository.save(job);
    }

    public List<JobEntity> getJobsByMechanic(Long mechanicId) {

        List<JobEntity> jobs = jobRepository.findByMechanicId(mechanicId);

        if(jobs.isEmpty()){
            throw new ResourceNotFoundException("No jobs found for mechanic id " + mechanicId);
        }

        return jobs;
    }
}