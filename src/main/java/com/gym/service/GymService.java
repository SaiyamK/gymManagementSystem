package com.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.entities.GymAdmin;
import com.gym.repository.GymRepository;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepo;

    public String addGymAdmin(GymAdmin gymAdmin) {
        gymRepo.save(gymAdmin);
        return "Gym admin added successfully";
    }

    public List<GymAdmin> getAllGymAdmins() {
        return gymRepo.findAll();
    }

    public GymAdmin getGymAdminById(Long id) {
        Optional<GymAdmin> optionalGymAdmin = gymRepo.findById(id);
        return optionalGymAdmin.orElse(null);
    }

    public String updateGymAdmin(Long id, GymAdmin updatedGymAdmin) {
        Optional<GymAdmin> optionalGymAdmin = gymRepo.findById(id);
        if (optionalGymAdmin.isPresent()) {
            GymAdmin existingGymAdmin = optionalGymAdmin.get();
            existingGymAdmin.setName(updatedGymAdmin.getName());
            existingGymAdmin.setLocation(updatedGymAdmin.getLocation());
            gymRepo.save(existingGymAdmin);
            return "Gym admin updated successfully";
        } else {
            return "Gym admin not found";
        }
    }

    public String deleteGymAdmin(Long id) {
        Optional<GymAdmin> optionalGymAdmin = gymRepo.findById(id);
        if (optionalGymAdmin.isPresent()) {
            gymRepo.deleteById(id);
            return "Gym admin deleted successfully";
        } else {
            return "Gym admin not found";
        }
    }
}