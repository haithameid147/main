package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Area;
import com.youtube.jwt.service.AreaService;



@CrossOrigin(origins="http://localhost:4200")
@RestController
//@JsonManagedReference
//@JsonBackReference

public class AreaController {

	@Autowired
	AreaService areaService;
	
	@GetMapping("/area")
	public List<Area> getAllArea(){
	return areaService.allArea(); 
	}
	 
	@GetMapping("/employees/{cityId}/allarea")
	public List<Area> getAllAreaByCityID(@PathVariable int cityId){
      return areaService.getAreaOfCity(cityId) ;
	}
	
//	@GetMapping("/area")
//	public List<Area> geetAllArea(){
//		
//		return areaService.allArea(); 
//	}
//	
	@GetMapping("/area/{idd}")
    public Area findAreaById (@PathVariable int idd) {
   	return areaService.findAreaById(idd);
    }
	
	@PostMapping("/addArea")
	public void addArea(@RequestBody Area newArea) {
	 areaService.addArea(newArea);
//		 return "area saved";
	}
	    
	@PutMapping("/addArea/{id}")
	public String ubdateArea(@PathVariable int id, @RequestBody Area newArea) {
		areaService.addArea(newArea);
		return "area ubdate";
	}
	
	@DeleteMapping("/deleteArea/{id}")
	public String deleteArea(@PathVariable int id) {
		areaService.deleteArea(id);
		return "city deleted";
		
	}
	
}
