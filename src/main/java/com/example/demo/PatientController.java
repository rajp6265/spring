package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin(origins = "*")
public class PatientController 
{
    @Autowired
    PatientRepo patientRepo;
   
    @PostMapping("/addPatient")
    @ResponseBody
    public Patient  addPatient(@RequestBody Patient patient)
    {
    	
    	 
    	patientRepo.save(patient);
    	 
    	Optional<Patient> checkForSuccess = patientRepo.findByEmail(patient.getEmail());
    	 
    	if(checkForSuccess!=null) {
    		 
    		System.out.println(patient.toString());
    		return patient;
    	}
    	  
    	   
    	else
    	{
    		System.out.println("fail");
    	 
    	   return null;
    	}
    	
    }
    
    @GetMapping("/patient/{patientmail}")
    @ResponseBody
    public Optional<Patient> aliens(@PathVariable("patientmail") String patientMail)
    {
 	   return patientRepo.findByEmail(patientMail);
    }
    
    @PutMapping("/updatePatient")
    @ResponseBody
    public Patient saveOrUpdatePatient(@RequestBody Patient patient)
    {
 	   patientRepo.save(patient);
 	   return patient;
    }
}
