package com.gym.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.entities.Users;
import com.gym.repository.UserRepository;

@Service
public class BusinessService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TrainerService trainerServe;
	@Autowired
	private PackageService packageServe;
	@Autowired
	private GymService gymServe;

	public String registerUser(String name, String email, String phone) {
		Users user = new Users(name, email, phone);
		try {
			userRepo.save(user);
		} catch (Exception e) {
			return "Exception Ocurred";
		}
		return "User Saved Successfully";
	}

	public String startGym(Long userId, Long gymId, Long trainerId, Long packageId) {
		Optional<Users> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            existingUser.setPackages(packageServe.getPackageById(packageId));
            existingUser.setTrainer(trainerServe.getTrainerById(trainerId));
            existingUser.setGymAdmin(gymServe.getGymAdminById(gymId));
            LocalDate date = LocalDate.now();
            existingUser.setPackageExpiryDate(date.plusMonths(1));
            userRepo.save(existingUser);
            return "User updated successfully";
        } else {
            return "User not found";
        }
	}

	public String updateUserPackage(Long userId, Long packageId) {
		Optional<Users> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            existingUser.setPackages(packageServe.getPackageById(packageId));
            userRepo.save(existingUser);
            return "User updated successfully";
        } else {
            return "User not found";
        }
	}

	public String entryInGym(Long userId) {
		Optional<Users> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            LocalDate todayDate = LocalDate.now();
            if (todayDate.isBefore(existingUser.getPackageExpiryDate())) {
            	long daysBetween = ChronoUnit.DAYS.between(todayDate, existingUser.getPackageExpiryDate());
            	return "Entry Allowed, Days Left For Renewal " + daysBetween + " Days";
            } else {
            	long daysBetween = ChronoUnit.DAYS.between(existingUser.getPackageExpiryDate(), todayDate);
            	return "Entry Denied, Package Expired Since " + daysBetween + " Days";
            }
        } else {
            return "User not found";
        }
	}

	public String renewal(Long userId) {
		Optional<Users> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            LocalDate todayDate = LocalDate.now();
            LocalDate renewalDate = null;
            if (todayDate.isBefore(existingUser.getPackageExpiryDate())) {
            	renewalDate = existingUser.getPackageExpiryDate().plusMonths(1);
            } else {
            	renewalDate = todayDate.plusMonths(1);
            }
            existingUser.setPackageExpiryDate(renewalDate);
            userRepo.save(existingUser);
            return "Renewal Success, Next Due Date: " + renewalDate;
        } else {
            return "User not found";
        }
	}

}
