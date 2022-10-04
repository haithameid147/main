/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youtube.jwt.controller;

import com.youtube.jwt.entity.Foundation;
import java.util.List;

/**
 *
 * @author eid
 */
public interface customRepo {
         public  List<Foundation>  findAllByServiceIdAndCityId(int servicesId,int cityId,String name);

    
}
