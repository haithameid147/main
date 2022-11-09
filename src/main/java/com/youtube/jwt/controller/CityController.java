package com.youtube.jwt.controller;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.City;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.entity.User;

//import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
//@CrossOrigin(origins="http://localhost:4200")
@RestController
//@Controller
public class CityController {
	
	@Autowired
	com.youtube.jwt.service.cityService cityService;
	
	@GetMapping("/employees")
	public List<City> getAllEmployees(){
		
		return cityService.all(); 
	}
	
//    @PostConstruct
//    public void initcity() {
//    	cityService.initCity1();
//    	cityService.initCity0();
//
//    	cityService.initCity2();
//    	cityService.initCity3();
//
//    }
  
	
	@GetMapping("/employeees")
	public String getAllEmployeees(){
		
		return "haitham"; 
	}
	@GetMapping("/test.html")
	public String teseeet(Model m){
		
		return "/test.html"; 
	//	return "redirect:/test";
	}
	
	@GetMapping("/user/{userName}")
	public List<City> geetAllEmployees(@PathVariable String userName){
		
		return cityService.all(); 
	}
	
	@GetMapping("/employees/{idd}")
	
    public City findById (@PathVariable int idd) {
   	return cityService.findById(idd) ;
   	
    }
	
	@PostMapping("/addCity")
	public String addCity(@RequestBody City newCity) {
		cityService.addCity(newCity);
		return "city saved";
	}
	@PutMapping("/addCity/{id}")
	public String ubdateCity(@PathVariable int id,
			@RequestBody City newCity) {
		cityService.addCity(newCity);
		return "city ubdate";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCity(@PathVariable int id) {
		cityService.deleteCity(id);
		return "city deleted";
	}
	
    

}
