package com.breakdown.admin_service.service;

import com.breakdown.admin_service.entity.AdminEntity;
import com.breakdown.admin_service.repository.AdminRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepo adminRepository;

    public AdminService(AdminRepo adminRepository) {
        this.adminRepository = adminRepository;
    }

    public String login(String email, String password) {

        Optional<AdminEntity> adminOpt = adminRepository.findByEmail(email);

        if (adminOpt.isEmpty()) {
            return "Admin not found";
        }

        AdminEntity admin = adminOpt.get();

        if (admin.getPassword().equals(password)) {
            return "Login Successful";
        } else {
            return "Invalid Password";
        }
    }

}