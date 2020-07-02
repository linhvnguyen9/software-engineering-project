/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.BookedBedDTO;
import com.e17cn2.dormitorymanagement.model.entity.BookedBed;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BVCN 88
 */
public interface BookedBedRepository extends JpaRepository<BookedBed, Integer>{
    
    @Override
    BookedBed save(BookedBed saved);
    
    
}