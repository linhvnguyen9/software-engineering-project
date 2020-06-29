/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.WaterMeterDTO;
import com.e17cn2.dormitorymanagement.model.entity.WaterMeter;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BVCN 88
 */
public interface WaterMeterRepository extends JpaRepository<WaterMeter, Integer>{
     List<WaterMeter> findAll();

     Optional<WaterMeter> findById(Integer id);

     WaterMeter save(WaterMeter saveWaterMeter);
     
     WaterMeter update(WaterMeter waterMeter);
     
     void delete(WaterMeter waterMeter);
}
