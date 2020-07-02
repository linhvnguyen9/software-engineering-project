/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.e17cn2.dormitorymanagement.view.createcontract;

import com.e17cn2.dormitorymanagement.dao.BedDAO;
import com.e17cn2.dormitorymanagement.model.entity.Bed;
import com.e17cn2.dormitorymanagement.model.entity.BookedBed;
import com.e17cn2.dormitorymanagement.model.entity.Contract;
import com.e17cn2.dormitorymanagement.model.entity.Employee;
import org.springframework.data.util.Pair;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author linh
 */
public class FindAvailableBedFrm extends JFrame {
    private Employee employee;

    public FindAvailableBedFrm() {
        initComponents();
    }

    public FindAvailableBedFrm(Employee employee) {
        this.employee = employee;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaxPrice = new javax.swing.JTextField();
        btnFindBed = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAvailableBedList = new javax.swing.JTable();
        btnSelectBeds = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Find available beds");

        txtStartDate.setText("DD/MM/YYYY");

        jLabel2.setText("Start date");

        jLabel3.setText("Max price");

        btnFindBed.setText("Find bed");
        btnFindBed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindBedActionPerformed(evt);
            }
        });

        tblAvailableBedList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Room id", "Room", "Bed code", "Type", "Price", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAvailableBedList);

        btnSelectBeds.setText("Select beds");
        btnSelectBeds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectBedsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(txtMaxPrice)))
                            .addComponent(btnFindBed, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(btnSelectBeds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindBed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelectBeds)
                        .addGap(296, 296, 296))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindBedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindBedActionPerformed
        try {
            Date startDate = getStartingDate();
            double maxPrice = Double.parseDouble(txtMaxPrice.getText());

            BedDAO dao = new BedDAO();
            List<Pair<Bed, String>> availableBeds = dao.findAvailableBeds(maxPrice, startDate);

            DefaultTableModel model = (DefaultTableModel) tblAvailableBedList.getModel();
            model.setRowCount(0);

            for (int i = 0; i < availableBeds.size(); i++) {
                Bed bed = availableBeds.get(i).getFirst();
                System.out.println("FindAvailableBedFrm bed: " + bed);
                String roomName = availableBeds.get(i).getSecond();

                model.addRow(new Object[]{bed.getId(), bed.getRoomId(), roomName, bed.getName(), bed.getType(), bed.getPrice(), bed.getDescription()});
            }
        } catch (ParseException e) {
            System.out.println("Error parsing date!");
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println("Error executing SQL");
            throwables.printStackTrace();
        }
    }//GEN-LAST:event_btnFindBedActionPerformed

    private void btnSelectBedsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectBedsActionPerformed
        selectBeds();
    }//GEN-LAST:event_btnSelectBedsActionPerformed

    private Date getStartingDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String startDateString = txtStartDate.getText();
        return formatter.parse(startDateString);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FindAvailableBedFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindAvailableBedFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindAvailableBedFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindAvailableBedFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FindAvailableBedFrm().setVisible(true);
            }
        });
    }

    private void selectBeds() {
        int[] selectedBedIndex = tblAvailableBedList.getSelectedRows();
        ArrayList<BookedBed> bookedBeds = new ArrayList<>();
        Contract contract = new Contract(0, new Date(), 0, null, null, null, employee, bookedBeds);

        if (selectedBedIndex.length > 0)
        {
            for (int i = 0; i < selectedBedIndex.length; i++) {
                DefaultTableModel model = (DefaultTableModel) tblAvailableBedList.getModel();
                int id = Integer.parseInt(model.getValueAt(selectedBedIndex[i], 0).toString());
                int roomId = Integer.parseInt(model.getValueAt(selectedBedIndex[i], 1).toString());
                String roomName = model.getValueAt(selectedBedIndex[i], 2).toString();
                String bedName = model.getValueAt(selectedBedIndex[i], 3).toString();
                String bedType = model.getValueAt(selectedBedIndex[i], 4).toString();
                double price = Double.parseDouble(model.getValueAt(selectedBedIndex[i], 5).toString());
                String desc = model.getValueAt(selectedBedIndex[i], 6).toString();
                Bed bed = new Bed(id, price, bedName, desc, bedType, roomName, roomId);

                try {
                    bookedBeds.add(new BookedBed(0, getStartingDate(), null, bed));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

//        for (BookedBed bookedBed : bookedBeds) {
//            System.out.println(bookedBed);
//        }

        FindStudentFrm frm = new FindStudentFrm(contract);
        frm.setVisible(true);
        this.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFindBed;
    private javax.swing.JButton btnSelectBeds;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAvailableBedList;
    private javax.swing.JTextField txtMaxPrice;
    private javax.swing.JTextField txtStartDate;
    // End of variables declaration//GEN-END:variables
}
