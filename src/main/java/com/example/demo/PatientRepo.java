package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Integer> 
{
   Optional<Patient> findByEmail(String email);
   //Optional<Patient> findById(Long Id);
}
