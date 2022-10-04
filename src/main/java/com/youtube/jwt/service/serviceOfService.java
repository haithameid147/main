package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.entity.City;



@Service
public class serviceOfService {
	
    @Autowired
	com.youtube.jwt.dao.serviceRepo serviceRepo ;
    
    public List<com.youtube.jwt.entity.Service> all () {
   	
   	return serviceRepo.findAll();
    }
    
    public com.youtube.jwt.entity.Service findById (int idd) {
    return serviceRepo.findById(idd).orElse(null);
    }
    
    public void add(com.youtube.jwt.entity.Service newCity) {
    	serviceRepo.save(newCity); 
    }
    public void initService1() {
        com.youtube.jwt.entity.Service city = new com.youtube.jwt.entity.Service();
        city.setName("نظافة");       
        serviceRepo.save(city);  
    }
    public void initService2() {
        com.youtube.jwt.entity.Service city = new com.youtube.jwt.entity.Service();
        city.setName("سباك");       
        serviceRepo.save(city);  
    }
    public void initService3() {
        com.youtube.jwt.entity.Service city = new com.youtube.jwt.entity.Service();
        city.setName("نجار");       
        serviceRepo.save(city);  
    }
    public void ubdate(com.youtube.jwt.entity.Service newCity) {
    	serviceRepo.save(newCity); 
    }
    public void delete(int id) {
    	serviceRepo.deleteById(id);
    }
    
}
