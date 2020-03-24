package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Integer>
 {
      Doctor findByEmail(String email);
      //Doctor findById(long Id);
 }
