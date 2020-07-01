
import com.e17cn2.dormitorymanagement.dao.BookedBedDAO;
import com.e17cn2.dormitorymanagement.dao.ContractDAO;
import com.e17cn2.dormitorymanagement.dao.InvoiceDAO;
import com.e17cn2.dormitorymanagement.model.entity.Contract;
import com.e17cn2.dormitorymanagement.model.entity.ElectricityMeter;
import com.e17cn2.dormitorymanagement.model.entity.Invoice;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author My PC
 */
public class test1 {
    public static void main(String[] args) throws SQLException {
        InvoiceDAO invoiceDAO=new InvoiceDAO();
        Invoice invoice=new Invoice();
           ArrayList<ElectricityMeter> listElectricityMeters=new ArrayList<>();
        BookedBedDAO bookedBedDAO=new BookedBedDAO();
        listElectricityMeters=bookedBedDAO.getElectricityMeterByIdBed(1);
        System.out.println(listElectricityMeters.get(1).getCurrentReading()+"");
        for (int i=0;i<listElectricityMeters.size();i++)
                System.out.println(listElectricityMeters.get(i).getCurrentReading());
    }
}
