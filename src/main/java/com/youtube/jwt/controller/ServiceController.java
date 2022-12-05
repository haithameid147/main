package com.youtube.jwt.controller;



import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;



//@CrossOrigin(origins = "http://10.101.0.80:4200")
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")

@RestController


public class ServiceController {
	
    @Autowired
	com.youtube.jwt.service.serviceOfService service ;
	
    
    @PostConstruct
    public void initRoleAndUser1() {
    	service.initService0();
    	service.initService1();
    	service.initService3();
    	service.initService2();       
    }
  
    
   
	@GetMapping("/allServices")
	public List<com.youtube.jwt.entity.Service> getAllEmployees(){
		return service.all(); 
	}
	
//	@GetMapping("/user/{userName}")
//	public List<Services> geetAllEmployees(@PathVariable String userName){
//		
//		return service.all(); 
//	}
	
	@GetMapping("/service/{idd}")
	
    public com.youtube.jwt.entity.Service findById (@PathVariable int idd) {
   	return service.findById(idd) ;
   	
    }
	
	@PostMapping("/addservice")
	public String addCity(@RequestBody com.youtube.jwt.entity.Service newCity) {
		service.add(newCity);
		return "Services saved";
	}
	@PutMapping("/addService/{id}")
	public String ubdateCity(@PathVariable int id,
		@RequestBody com.youtube.jwt.entity.Service newCity) {
		service.add(newCity);
		return "Services ubdate";
	}
	   
	@DeleteMapping("/deleteService/{id}")
	public String deleteCity(@PathVariable int id) {
		service.delete(id);
		return "Services deleted";
	}
	

	
}
