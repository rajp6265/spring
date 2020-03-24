package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AlienRepo extends JpaRepository<Alien,Integer>
{
    List<Alien> findByTech(String tech);
    List<Alien> findByAidGreaterThan(int Aid);
    @Query("from Alien where tech = ?1 ORDER BY aname")
    List<Alien> findByTechSorted(String tech);
    
}
