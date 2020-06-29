/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.dao.repository;

import com.e17cn2.dormitorymanagement.model.dto.BedDTO;
import com.e17cn2.dormitorymanagement.model.dto.BookedBedDTO;
import com.e17cn2.dormitorymanagement.model.dto.RoomDTO;
import com.e17cn2.dormitorymanagement.model.entity.Bed;
import com.e17cn2.dormitorymanagement.model.entity.BookedBed;
import com.e17cn2.dormitorymanagement.model.entity.Room;

/**
 *
 * @author TGDD
 */
public class ConvertToDto {
   private BedRepository bedRepository;
   private BookedBedRepository bookedBedRepository;
   private ContractRepository contractRepository;
   private ElectricityRepository electricityRepository;
   private InvoiceRepository invoiceRepository;
   private RoomRepository roomRepository;
   private ServiceRepository serviceRepository;
   private StudentRepository studentRepository;
   private UsedServiceRepository usedServiceRepository;
   private WaterMeterRepository waterMeterRepository;
    
    private BedDTO convertBedToDto(Bed bed){
        BedDTO dto;
        Room room = roomRepository.findById(bed.getRoomId()).orElse(null);
        if(bed != null){
            dto = new BedDTO(bed.getId(),
                             bed.getPrice(), 
                             bed.getDescription(),
                             bed.getType()
                             );   
            return dto;
        }else{
            return null; 
        }
    }
    
    private BookedBedDTO convertBookedBedToDTO(BookedBed bookedBed){
        BookedBedDTO dto;
        Bed bed = bedRepository.findById(bookedBed.getBedId()).orElse(null);
        if(bookedBed != null){
            dto = new BookedBedDTO(bookedBed.getBedId(),
                    bookedBed.getCheckinDate(),
                    bookedBed.getCheckoutDate(),
                    bookedBed.getContractId(),
                    convertBedToDto(bed));
        }
    }
    
    private RoomDTO convertRoomToDTO(Room room){
        RoomDTO dTO;
        room = roomRepository.findById(Integer.SIZE)
    }
}
