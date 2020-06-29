/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.ServiceDTO;
import com.e17cn2.dormitorymanagement.model.entity.Service;
import java.util.List;
import java.util.Optional;
import com.e17cn2.dormitorymanagement.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BVCN 88
 */
public interface ServiceRepository extends JpaRepository<Service, Integer>{
     List<Service> findAll();

     Optional<Service> findById(Integer id);

     Service save(Service saveService);
     
     Service update(Service updateService);
     
     void delete(Service deleteService);
}
