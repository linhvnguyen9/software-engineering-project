/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.ContractDTO;
import com.e17cn2.dormitorymanagement.model.entity.Contract;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BVCN 88
 */
public interface ContractRepository extends JpaRepository<Contract, Integer>{
     @Override
     List<Contract> findAll();

     @Override
     Optional<Contract> findById(Integer id);

     @Override
     Contract save(Contract saved);
     
     Contract update(Contract updated);
     
     @Override
     void delete(Contract deleted);
}
