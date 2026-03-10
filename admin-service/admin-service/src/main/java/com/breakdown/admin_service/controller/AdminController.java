package com.breakdown.admin_service.controller;

import com.breakdown.admin_service.entity.AdminLoginRequest;
import com.breakdown.admin_service.service.AdminService;
import com.breakdown.admin_service.service.FetchAllUsers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final FetchAllUsers fetchAllUsers;

    public AdminController(AdminService adminService,
                           FetchAllUsers fetchAllUsers
                          ) {
        this.adminService = adminService;
        this.fetchAllUsers = fetchAllUsers;

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminLoginRequest request) {
        String response = adminService.login(
                request.getEmail(),
                request.getPassword()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Object>> getAllUsers() {
        return ResponseEntity.ok(fetchAllUsers.getAllUsers());
    }

    @GetMapping("/mechanics")
    public ResponseEntity<List<Object>> getAllMechanics() {
        return ResponseEntity.ok(fetchAllUsers.getAllMechanics());
    }

    @GetMapping("/requests")
    public ResponseEntity<List<Object>> getAllRequests() {
        return ResponseEntity.ok(fetchAllUsers.getAllRequests());
    }

    @PutMapping("/mechanics/{id}/approve")
    public ResponseEntity<String> mechanicApproval(@PathVariable("id") Long id) {
        fetchAllUsers.mechanicApproval(id);
        return ResponseEntity.ok("Mechanic Approved Successfully");
    }
}