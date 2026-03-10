package com.breakdown.mechanic_service.controller;

import com.breakdown.mechanic_service.dto.BreakdownRequestDTO;
import com.breakdown.mechanic_service.entity.MechanicEntity;
import com.breakdown.mechanic_service.service.FetchRequestService;
import com.breakdown.mechanic_service.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mechanics")
public class MechanicController {
    @Autowired
    private MechanicService mechanicService;
    @Autowired
    private FetchRequestService requestService;

    @PostMapping("/register")
    public ResponseEntity<MechanicEntity> register(@RequestBody MechanicEntity mechanic) {
        MechanicEntity mechanicEntity = mechanicService.register(mechanic);
        return ResponseEntity.ok(mechanicEntity);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,@RequestParam String password) {
        return mechanicService.login(email,password);
    }
    @PutMapping("/approve/{id}")
    public String approveMechanic(@PathVariable Long id) {

      return mechanicService.approveMechanic(id);
    }
    @GetMapping
    public List<MechanicEntity> getAllMechanics(){

        return mechanicService.getAllMechanics();
    }
    @GetMapping("/requests/new")
    public List<BreakdownRequestDTO> getNewRequests(){
      return  requestService.getNewRequests();
    }

}
