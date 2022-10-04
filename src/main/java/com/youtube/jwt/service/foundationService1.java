package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.entity.Foundation;


@Service
public class foundationService1 {
	@Autowired
	com.youtube.jwt.dao.foundationRepo foundationRepo ;
	
	public List<Foundation>  getAllfoundationByserviceID(int servicesId){
		return foundationRepo.findByServiceId(servicesId) ;
	}
	
	public List<Foundation>  getFoundationOfServiceId(int servicesId){
		return foundationRepo.findByServiceId(servicesId) ;
	}
//	public List<Foundation>  getAlllfoundationBySearch(int servicesId,int cityId){
//		return foundationRepo.findAllByServiceIdAndCityId(servicesId,cityId) ;
//	}
        	public List<Foundation>  getFoundationOfCityId(int cityId){
		return foundationRepo.findByCityId(cityId) ;
	}
        
        	public List<Foundation>  getFoundationOfAppUserName(String appUserID){
	    //	return foundationRepo.findByUserUserName(appUserID);
	    	return foundationRepo.findByUserUserName(appUserID);
	}
        	public List<Foundation>  getFoundationByNameContaining(String name){
	    	return foundationRepo.findBynameArContaining(name);
	}
    public List<Foundation> all () {
   	System.out.print(foundationRepo.findAll()); 
   	return foundationRepo.findAll();
    }
    
    public Foundation findFoundationById (int idd) {
   	   
   	return foundationRepo.findById(idd).orElse(null);
   	//    return areaRepo.findById(idd);

    }
    public int findserviceIdByFoundationById (int idd) {
    	int id ;
    	Foundation f = new Foundation() ;
    	f = foundationRepo.findById(idd).orElse(null);
    	id = f.getService().getId() ;
    	return id ;
   //	return foundationRepo.findById(idd).orElse(null);
   	//    return areaRepo.findById(idd);

    }
    public int findCityIdByFoundationById (int idd) {
    	int id ;
    	Foundation f = new Foundation() ;
    	f = foundationRepo.findById(idd).orElse(null);
    	id = f.getCity().getId() ;
    	return id ;
   //	return foundationRepo.findById(idd).orElse(null);
   	//    return areaRepo.findById(idd);

    }
    
    public void addFoundation(Foundation newFoundation) {
    	
    	foundationRepo.save(newFoundation); 
    	
    }
    public void ubdateFoundation(Foundation newFoundation) {
    	foundationRepo.save(newFoundation); 
    }
    public void deleteFoundation(int id) {
    	foundationRepo.deleteById(id);
    }

//	public List<Foundation> getAllfoundationBySearch(int servicesId, int cityId) {
//		// TODO Auto-generated method stub
//		return foundationRepo.findAllByServiceIdAndCityId(servicesId,cityId) ;
//	}




}
