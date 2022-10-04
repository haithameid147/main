package com.youtube.jwt.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Area;


@Repository
public interface AreaRepo extends JpaRepository<Area, Integer>{
	
	  //public List<Area> findByCityId(int cityId);
        public  List<Area> findByCityId(int cityId);
        //List<Area> findByCityId(City city);
      //  List<Area> findByCity(City city);
        
	

}
