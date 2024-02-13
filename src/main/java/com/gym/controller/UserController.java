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

import com.gym.entities.Users;
import com.gym.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService uservice;

    @PostMapping("/add")
    public String addUser(@RequestBody Users u) {
        return uservice.addUser(u);
    }

    @GetMapping("/getAll")
    public List<Users> getAllUsers() {
        return uservice.getAll();
    }

    @GetMapping("/getDetailsOfUser/{id}")
    public ResponseEntity<Users> getDetails(@PathVariable("id") Long id) {
        Users user = uservice.getDetailsOfUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        String result = uservice.updateUser(id, updatedUser);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String result = uservice.deleteUser(id);
        return ResponseEntity.ok(result);
    }
}
