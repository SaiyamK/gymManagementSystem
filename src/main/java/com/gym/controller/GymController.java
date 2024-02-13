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

import com.gym.entities.GymAdmin;
import com.gym.service.GymService;

@RestController
@RequestMapping("/gym")
public class GymController {

    @Autowired
    private GymService gymService;

    @PostMapping("/add")
    public String addGym(@RequestBody GymAdmin gymAdmin) {
        return gymService.addGymAdmin(gymAdmin);
    }

    @GetMapping("/getAll")
    public List<GymAdmin> getAllGymAdmins() {
        return gymService.getAllGymAdmins();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GymAdmin> getGymAdminById(@PathVariable Long id) {
        GymAdmin gymAdmin = gymService.getGymAdminById(id);
        return ResponseEntity.ok(gymAdmin);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateGymAdmin(@PathVariable Long id, @RequestBody GymAdmin updatedGymAdmin) {
        String result = gymService.updateGymAdmin(id, updatedGymAdmin);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGymAdmin(@PathVariable Long id) {
        String result = gymService.deleteGymAdmin(id);
        return ResponseEntity.ok(result);
    }
}


