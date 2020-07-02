package com.e17cn2.dormitorymanagement.dao;

import static com.e17cn2.dormitorymanagement.dao.DAO.con;
import com.e17cn2.dormitorymanagement.model.entity.UsedService;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsedServiceDAO extends DAO{
    
    public boolean saveUsedService(UsedService usedService) throws SQLException{
        InvoiceDAO invoice = new InvoiceDAO();
        String sql = "INSERT INTO dichvusudung VALUES (?,?,null,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(0, usedService.getService().getId());
        ps.setInt(1, invoice.increaseInvoiceId());
        ps.setDouble(3, usedService.getQty());
        
        return ps.execute();
    }
}
