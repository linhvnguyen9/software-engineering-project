/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.ElectricityMeterDTO;
import com.e17cn2.dormitorymanagement.model.entity.ElectricityMeter;
import java.util.List;
import java.util.Optional;
import com.e17cn2.dormitorymanagement.model.entity.ElectricityMeter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BVCN 88
 */
public interface ElectricityRepository extends JpaRepository<ElectricityMeter, Integer>{
     List<ElectricityMeter> findAll();

     Optional<ElectricityMeter> findById(Integer id);

     ElectricityMeter save(ElectricityMeter saveElectricityMeter);
     
     ElectricityMeter update(ElectricityMeter updateElectricityMeter);
     
     void delete(ElectricityMeter deleteElectricityMeter);
}
