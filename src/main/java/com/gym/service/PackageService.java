package com.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.entities.Packages;
import com.gym.repository.PackageRepository;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepo;

    public String addPackage(Packages p) {
        packageRepo.save(p);
        return "Package added successfully";
    }

    public List<Packages> getAllPackages() {
        return packageRepo.findAll();
    }

    public Packages getPackageById(Long id) {
        Optional<Packages> optionalPackage = packageRepo.findById(id);
        return optionalPackage.orElse(null);
    }

    public String updatePackage(Long id, Packages updatedPackage) {
        Optional<Packages> optionalPackage = packageRepo.findById(id);
        if (optionalPackage.isPresent()) {
            Packages existingPackage = optionalPackage.get();
            existingPackage.setPackageName(updatedPackage.getPackageName());
            existingPackage.setPackageFees(updatedPackage.getPackageFees());
            existingPackage.setMealIncluded(updatedPackage.isMealIncluded());
            packageRepo.save(existingPackage);
            return "Package updated successfully";
        } else {
            return "Package not found";
        }
    }

    public String deletePackage(Long id) {
        Optional<Packages> optionalPackage = packageRepo.findById(id);
        if (optionalPackage.isPresent()) {
            packageRepo.deleteById(id);
            return "Package deleted successfully";
        } else {
            return "Package not found";
        }
    }
}
