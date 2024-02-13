package com.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.entities.GymAdmin;

@Repository
public interface GymRepository extends JpaRepository<GymAdmin, Long>{

}
