package com.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.entities.Trainer;
import com.gym.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService tservice;

    @PostMapping("/add")
    public String addTrainer(@RequestBody Trainer t) {
        return tservice.addTrainer(t);
    }

    @GetMapping("/get")
    public List<Trainer> getAllTrainers() {
        return tservice.getAllTrainer();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        Trainer trainer = tservice.getTrainerById(id);
        return ResponseEntity.ok(trainer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTrainer(@PathVariable Long id, @RequestBody Trainer updatedTrainer) {
        String result = tservice.updateTrainer(id, updatedTrainer);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable Long id) {
        String result = tservice.deleteTrainer(id);
        return ResponseEntity.ok(result);
    }
}