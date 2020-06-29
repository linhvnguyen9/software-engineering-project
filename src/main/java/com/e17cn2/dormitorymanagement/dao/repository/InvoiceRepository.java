/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.InvoiceDTO;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BVCN 88
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
     List<Invoice> findAll();

     Optional<Invoice> findById(Integer id);

     Invoice save(Invoice saveInvoice);
     
     Invoice update(Invoice updateInvoice);
     
     void delete(Invoice deleteInvoice);
}
