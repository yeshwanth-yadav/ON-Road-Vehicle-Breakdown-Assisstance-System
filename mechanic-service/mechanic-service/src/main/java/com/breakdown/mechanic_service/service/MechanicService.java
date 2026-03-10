package com.breakdown.mechanic_service.service;

import com.breakdown.mechanic_service.entity.MechanicEntity;
import com.breakdown.mechanic_service.exception.BadRequestException;
import com.breakdown.mechanic_service.exception.ResourceNotFoundException;
import com.breakdown.mechanic_service.repository.MechanicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicService {

    @Autowired
    private MechanicRepo mechanicRepository;

    public MechanicEntity register(MechanicEntity mechanic) {

        if(mechanic == null){
            throw new BadRequestException("Mechanic details cannot be empty");
        }

        return mechanicRepository.save(mechanic);
    }

    public String login(String email, String password) {

        MechanicEntity mechanic = mechanicRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Mechanic not found with email " + email));

        if(!mechanic.getPassword().equals(password)){
            throw new BadRequestException("Invalid password");
        }

        return "Login Successful";
    }

    public String approveMechanic(Long id) {

        MechanicEntity mech = mechanicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mechanic not found with id " + id));

        mech.setApproved(true);
        mechanicRepository.save(mech);

        return "Mechanic Approved Successfully";
    }

    public List<MechanicEntity> getAllMechanics() {

        List<MechanicEntity> mechanics = mechanicRepository.findAll();

        if(mechanics.isEmpty()){
            throw new ResourceNotFoundException("No mechanics found");
        }

        return mechanics;
    }
}