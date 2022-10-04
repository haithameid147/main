/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Orders;

/**
 *
 * @author eid
 */


//@CrossOrigin(origins = "http://10.101.0.80:4200")
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class OrdersController {
    	@Autowired
        com.youtube.jwt.service.ordersService ordersService ;
        
        	
	@GetMapping("/orders")
	public List<Orders> getAllorders(){
	return ordersService.allOrders(); 
	}
	 
	@GetMapping("/service/{servicesId}/orders")
	public List<Orders> getAllordersByserviceID(@PathVariable int servicesId){
      return ordersService.getOrdersOfServiceId(servicesId) ;
	}
        @GetMapping("/city/{cityId}/oders")
	public List<Orders> getAllordersByCityID(@PathVariable int cityId){
      return ordersService.getOrdersOfCityId(cityId);
	}

//	@GetMapping("/area")
//	public List<Area> geetAllArea(){
//		
//		return areaService.allArea(); 
//	}
//	
	@GetMapping("/orders/{idd}")
    public Orders findOrdersById (@PathVariable int idd) {
   	return ordersService.findOrdersById(idd) ;
    }
	
	@PostMapping("/addorders")
	public void addfoundation(@RequestBody Orders newArea) {
		ordersService.addOrders(newArea);
	//	return "area saved";
	}
	
	@PutMapping("/addorders/{id}")
	public String ubdatefoundation(@PathVariable int id, @RequestBody Orders newFoundation) {
		ordersService.addOrders(newFoundation);
		return "area ubdate";
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public String deleteArea(@PathVariable int id) {
		ordersService.deleteOrders(id);
		return "city deleted";
		
	}

}
