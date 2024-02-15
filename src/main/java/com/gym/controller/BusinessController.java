package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.service.BusinessService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/business")
public class BusinessController {

	@Autowired
    private BusinessService businessService;

    @PostMapping("/registerUser/{name}/{email}/{phone}")
    public String addUser(@Valid @PathVariable String name, @Valid @PathVariable String email, @Valid @PathVariable String phone) {
        return businessService.registerUser(name, email, phone);
    }

    @PostMapping("/startGym/{userId}/{gymId}/{trainerId}/{packageId}")
    public String startGym(@PathVariable Long userId, @PathVariable Long gymId, @PathVariable Long trainerId, @PathVariable Long packageId) {
        return businessService.startGym(userId, gymId, trainerId, packageId);
    }

    @PostMapping("/updateUserPackage/{userId}/{packageId}")
    public String updateUserPackage(@PathVariable Long userId, @PathVariable Long packageId) {
        return businessService.updateUserPackage(userId, packageId);
    }

    @GetMapping("/entryInGym/{userId}")
    public String entryInGym(@PathVariable Long userId) {
        return businessService.entryInGym(userId);
    }
    
    @GetMapping("/renewal/{userId}")
    public String renewal(@PathVariable Long userId) {
        return businessService.renewal(userId);
    }

}
