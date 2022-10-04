package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AreaRepo;
import com.youtube.jwt.entity.Area;



@Service
public class AreaService {
	@Autowired
	AreaRepo areaRepo ;
	
	public List<Area>  getAreaOfCity(int cityId){
		return areaRepo.findByCityId(cityId) ;
	}
	
    public List<Area> allArea () {
   	System.out.print(areaRepo.findAll()); 
   	return areaRepo.findAll();
    }
    
    public Area findAreaById (int idd) {
   	   
   	return areaRepo.findById(idd).orElse(null);
   	//    return areaRepo.findById(idd);

    }
    public void addArea(Area newArea) {
    	areaRepo.save(newArea); 
    	
    }
    public void ubdateArea(Area newArea) {
    	areaRepo.save(newArea); 
    }
    public void deleteArea(int id) {
    	areaRepo.deleteById(id);
    }


}
