
import com.e17cn2.dormitorymanagement.dao.InvoiceDAO;
import com.e17cn2.dormitorymanagement.model.entity.Room;
import com.e17cn2.dormitorymanagement.model.entity.Student;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TGDD
 */
public class testStat {
    public static void main(String[] args) {
        InvoiceDAO invoiceDAO = new InvoiceDAO();
         ArrayList<Room> listRooms = new ArrayList<>();
       listRooms = invoiceDAO.getRoom();
       for (Room student:listRooms)
            System.out.println(student.getRoomName());
    }
}
