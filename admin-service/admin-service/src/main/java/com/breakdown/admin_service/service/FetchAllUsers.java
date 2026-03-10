package com.breakdown.admin_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FetchAllUsers {

    private final RestTemplate restTemplate = new RestTemplate();


    public List<Object> getAllUsers() {
        return restTemplate.getForObject(
                "http://localhost:8083/users",
                List.class
        );
    }

        public List<Object> getAllRequests() {
            return restTemplate.getForObject(
                    "http://localhost:8083/requests",
                    List.class
            );
    }
    public List<Object> getAllMechanics() {
        return restTemplate.getForObject(
                "http://localhost:8082/mechanics",
                List.class
        );
    }

    public void mechanicApproval(Long id) {
        restTemplate.put(
                "http://localhost:8082/mechanics/approve/{id}",
                null,
                id
        );
    }
}