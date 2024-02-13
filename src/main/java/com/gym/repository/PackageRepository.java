package com.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.entities.Packages;

@Repository
public interface PackageRepository extends JpaRepository<Packages, Long>{



}
