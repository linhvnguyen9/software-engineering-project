/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.StudentDTO;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BVCN 88
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
     List<Student> findAll();

     Optional<Student> findById(Integer id);

     Student save(Student saveStudent);
     
     StudentDTO update(Student updStudent);
     
     void delete(Student deleteStudent);
}
