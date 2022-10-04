/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youtube.jwt.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.entity.Orders;

/**
 *
 * @author eid
 */
@Service
public class ordersService {
    
    	@Autowired
        com.youtube.jwt.dao.ordersRepo ordersRepo ;
        
        	
	public List<Orders>  getOrdersOfServiceId(int servicesId){
		return ordersRepo.findByServiceId(servicesId) ;
	}
        	public List<Orders>  getOrdersOfCityId(int cityId){
		return ordersRepo.findByCityId(cityId) ;
	}
        
 
	
    public List<Orders> allOrders () {
   	System.out.print(ordersRepo.findAll()); 
   	return ordersRepo.findAll();
    }
    
    public Orders findOrdersById (int idd) {
   	              
   	return ordersRepo.findById(idd).orElse(null);
   	//    return areaRepo.findById(idd);

    }
    public void addOrders(Orders newOrders) {
    	ordersRepo.save(newOrders); 
    	
    }
    public void ubdateOrders(Orders newOrders) {
    	ordersRepo.save(newOrders); 
    }
    public void deleteOrders(int id) {
    	ordersRepo.deleteById(id);
    }


    
    
}
