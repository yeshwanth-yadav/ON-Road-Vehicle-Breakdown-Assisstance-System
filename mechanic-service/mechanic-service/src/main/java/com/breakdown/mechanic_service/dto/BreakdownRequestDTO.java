package com.breakdown.mechanic_service.dto;

import lombok.Data;

@Data
public class BreakdownRequestDTO {
    private Long id;
    private Long userId;
    private String vehicleType;
    private String problemDescription;
    private String location;
    private String status;


}