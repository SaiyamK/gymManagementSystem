package com.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.entities.Users;
import com.gym.exception.UserNotFoundException;
import com.gym.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository urepo;

    public String addUser(Users u) {
    	System.out.println(u.toString());
        urepo.save(u);
        return "User added successfully";
    }

    public List<Users> getAll() {
        return urepo.findAll();
    }

    public Users getDetailsOfUserById(Long id) {
        Optional<Users> optionalUser = urepo.findById(id);
        return optionalUser.orElse(null);
    }

    public String updateUser(Long id, Users updatedUser) throws UserNotFoundException {
        Optional<Users> optionalUser = urepo.findById(id);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setGymAdmin(updatedUser.getGymAdmin());
            existingUser.setPackages(updatedUser.getPackages());
            existingUser.setPhoneNo(updatedUser.getPhoneNo());
            existingUser.setTrainer(updatedUser.getTrainer());
            urepo.save(existingUser);
            return "User updated successfully";
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }

    public String deleteUser(Long id) {
        Optional<Users> optionalUser = urepo.findById(id);
        if (optionalUser.isPresent()) {
            urepo.deleteById(id);
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }
}
