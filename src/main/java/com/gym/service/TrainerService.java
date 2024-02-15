package com.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.entities.Trainer;
import com.gym.repository.TrainerRepository;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trepo;

    public String addTrainer(Trainer t) {
        trepo.save(t);
        return "Trainer added successfully";
    }

    public List<Trainer> getAllTrainer() {
        return trepo.findAll();
    }

    public Trainer getTrainerById(Long id) {
        Optional<Trainer> optionalTrainer = trepo.findById(id);
        return optionalTrainer.orElse(null);
    }

    public String updateTrainer(Long id, Trainer updatedTrainer) {
        Optional<Trainer> optionalTrainer = trepo.findById(id);
        if (optionalTrainer.isPresent()) {
            Trainer existingTrainer = optionalTrainer.get();
            existingTrainer.setPhoneNo(updatedTrainer.getPhoneNo());
            existingTrainer.setGymAdmin(updatedTrainer.getGymAdmin());
            existingTrainer.setTrainerName(updatedTrainer.getTrainerName());
            existingTrainer.setSpecialization(updatedTrainer.getSpecialization());
            trepo.save(existingTrainer);
            return "Trainer updated successfully";
        } else {
            return "Trainer not found";
        }
    }

    public String deleteTrainer(Long id) {
        Optional<Trainer> optionalTrainer = trepo.findById(id);
        if (optionalTrainer.isPresent()) {
            trepo.deleteById(id);
            return "Trainer deleted successfully";
        } else {
            return "Trainer not found";
        }
    }
}