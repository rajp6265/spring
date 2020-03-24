package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin(origins = "*")
public class DoctorController 
{
   @Autowired
   DoctorRepo doctorRepo;
   
   @PostMapping("/addDoctor")
   @ResponseBody
   public Doctor addDoctor(@RequestBody Doctor doctor)
   {
	   doctorRepo.save(doctor);
	   Doctor checkForSuccess = doctorRepo.findByEmail(doctor.getEmail());
	   if(checkForSuccess!=null)
	   {return doctor;}
	   else
	   {
		   return null;
	   }    
   }
   
   @GetMapping("/doctor/{doctoremail}")
   @ResponseBody
   public Doctor aliens(@PathVariable("doctoremail") String doctorEmail)
   {
	   return doctorRepo.findByEmail(doctorEmail);
   }
   
   @PutMapping("/updateDoctor")
   @ResponseBody
   public Doctor saveOrUpdateDoctor(@RequestBody Doctor doctor)
   {
	   doctorRepo.save(doctor);
	   return doctor;
   }
}
