package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.entity.City;


@Service
public class cityService {
	
     @Autowired
     com.youtube.jwt.dao.cityRepo cityRepo ;
     
     public List<City> all () {
    	
    	return cityRepo.findAll();
     }
     
     public City findById (int idd) {
    	
     return cityRepo.findById(idd).orElse(null);
     }
     public void addCity(City newCity) {
    	 cityRepo.save(newCity); 
     }
     public void ubdateCity(City newCity) {
    	 cityRepo.save(newCity); 
     }
     public void deleteCity(int id) {
    	 cityRepo.deleteById(id);
     }
     

     public void initCity1() {

         City city = new City();
         city.setNameAr("نالقاهاره");
         city.setNameEn("ccairo");
         cityRepo.save(city);
         
     }
     public void initCity2() {

         City city = new City();
         city.setNameAr("االاسكندرية");
         city.setNameEn("aalex");
         cityRepo.save(city);
         
     }
     public void initCity3() {

         City city = new City();
         city.setNameAr("طنطاا");
         city.setNameEn("taanta");
         cityRepo.save(city);
         
     }
     
}
