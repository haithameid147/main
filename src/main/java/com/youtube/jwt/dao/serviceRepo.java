package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Service;


@Repository
public interface serviceRepo  extends JpaRepository <Service, Integer>{
	

}
