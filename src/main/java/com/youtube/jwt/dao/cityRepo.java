package com.youtube.jwt.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.City;


@Repository
public interface cityRepo extends JpaRepository <City, Integer>{

}
