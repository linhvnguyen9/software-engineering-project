/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.RoomDTO;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BVCN 88
 */
public interface RoomRepository extends JpaRepository<Room, Integer>{
     List<Room> findAll();

     Optional<Room> findById(Integer id);

     Room save(Room saveRoom);
     
     Room update(Room room);
     
     void delete(Room room);
}
