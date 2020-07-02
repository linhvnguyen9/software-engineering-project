
import com.e17cn2.dormitorymanagement.dao.UsedServiceDAO;
import com.e17cn2.dormitorymanagement.model.entity.UsedService;
import java.sql.Date;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author My PC
 */
public class NewClass {
    public static void main(String[] args) {
        UsedServiceDAO usedServiceDAO=new UsedServiceDAO();
        UsedService usedService=new UsedService();
        usedService.setCheckUnpaid(true);
        usedService.setId(1);
        usedServiceDAO.UpdateUsedService(usedService);
        
        //System.out.println(Date.valueOf(LocalDate.now().format(''))+" date");
    }
}
