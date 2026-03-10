package com.breakdown.mechanic_service.service;

import com.breakdown.mechanic_service.dto.BreakdownRequestDTO;
import com.breakdown.mechanic_service.exception.BadRequestException;
import com.breakdown.mechanic_service.exception.ResourceNotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FetchRequestService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<BreakdownRequestDTO> getNewRequests() {

        try {

            ResponseEntity<List<BreakdownRequestDTO>> response =
                    restTemplate.exchange(
                            "http://localhost:8083/requests/new?status=NEW",
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<BreakdownRequestDTO>>() {
                            }
                    );

            List<BreakdownRequestDTO> requests = response.getBody();

            if (requests == null || requests.isEmpty()) {
                throw new ResourceNotFoundException("No new breakdown requests found");
            }

            return requests;

        } catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("User service API not found");

        } catch (ResourceAccessException e) {
            throw new BadRequestException("User service is not reachable");

        } catch (Exception e) {
            throw new BadRequestException("Unable to fetch breakdown requests");
        }
    }

    public void updateRequestStatus(Long requestId) {

        String url = "http://localhost:8083/requests/" + requestId + "/status?status=ASSIGNED";

        restTemplate.put(url, null);
    }
}