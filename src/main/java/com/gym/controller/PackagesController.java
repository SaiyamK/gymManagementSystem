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

import com.gym.entities.Packages;
import com.gym.service.PackageService;

@RestController
@RequestMapping("/package")
public class PackagesController {

    @Autowired
    private PackageService packService;

    @PostMapping("/add")
    public String addPackage(@RequestBody Packages p) {
        return packService.addPackage(p);
    }

    @GetMapping("/get")
    public List<Packages> getAllPackages() {
        return packService.getAllPackages();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Packages> getPackageById(@PathVariable Long id) {
        Packages pack = packService.getPackageById(id);
        return ResponseEntity.ok(pack);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePackage(@PathVariable Long id, @RequestBody Packages updatedPackage) {
        String result = packService.updatePackage(id, updatedPackage);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePackage(@PathVariable Long id) {
        String result = packService.deletePackage(id);
        return ResponseEntity.ok(result);
    }
}
