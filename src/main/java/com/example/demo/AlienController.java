package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController
{
	@Autowired
	AlienRepo repo;
   @RequestMapping("home")	
   public String home()
   {  
	    
	   return "home";
   }
   
   @RequestMapping("/addAlien")
   public String addAlien(Alien alien)
   {
	   repo.save(alien);
	   return "home";
   }
   
   //Post method 
   @PostMapping("/Alien")
   public Alien Postalien(@RequestBody Alien alien)
   {
	   repo.save(alien);
	   return alien;
   }
   
   @RequestMapping("/getAlien")
    public ModelAndView getAliens()
    {
	   //Send aliens to JSP
	   ModelAndView mv = new ModelAndView();
	   Iterable<Alien> aliens = repo.findAll();
	   mv.addObject("aliens",aliens);
	   mv.setViewName("home");
	   //Query
	   System.out.println("_____________ONLY JAVA ALIENS_____________");
	   System.out.println(repo.findByTech("java"));
	   System.out.println("______________GRETHER THAN 102 ID (IN SORTED ORDER OF NAME_____)");
	   System.out.println(repo.findByAidGreaterThan(102));
	   System.out.println("____custom QUERY_______________________");
	   System.out.println(repo.findByTechSorted("android"));
	   return mv; 
	   
    }
   @RequestMapping("/updateAlien")
    public String updateAlien(Alien alien)
    { 
	  
	    repo.deleteById(alien.getAid());
	    System.out.println("__________________Alien Deleted________________");
	    repo.save(alien);
	    System.out.println("__________________Alien Updated________________");
	  
	   return "updateAlien";
    }
   @GetMapping(path="/aliens")
   @ResponseBody
   public List<Alien> alien()
   {
	   List<Alien> al = repo.findAll();
	   return al;
   }

   @RequestMapping("/aliens/{aid}")
   @ResponseBody
   public Optional<Alien> aliens(@PathVariable("aid") int aid)
   {
	   return repo.findById(aid);
   }
   
   @DeleteMapping("/Alien/{aid}")
   public String deleteAlien(@PathVariable int aid)
   {
	 Alien a = repo.getOne(aid);
	 repo.delete(a);
	 return "deleted";
   }
   
   @PutMapping("/putAlien")
   public Alien saveOrUpdateAlien(@RequestBody Alien alien)
   {
	   repo.save(alien); 
	   return alien;
   }
   
}
