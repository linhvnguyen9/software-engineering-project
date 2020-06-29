/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.BedDTO;
import com.e17cn2.dormitorymanagement.model.entity.Bed;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BVCN 88
 */
public interface BedRepository extends JpaRepository<Bed, Integer>{
     List<Bed> findAll();

     Optional<Bed> findById(Integer id);
     
     List<Bed> findAllByRoomId(int id);

     Bed save(Bed saved);
     
     Bed update(Bed updateBed);
     
     void delete(Bed DeleteBed);
     
}
