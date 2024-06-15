/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package manage_hotel;

import java.awt.print.PrinterException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javazoom.jl.player.Player;
/**
 *
 * @author Admin
 */
public class BillPrint extends javax.swing.JDialog {
String id=BillDetails.idd;

String idCus;
String staff;
String CCCD;
    String nm;
    String mobile;
    String email;
    String roomnumber;
    String bed;
    String type;
    String indate;
    String outdate;
    String price;
    String days;
    String amount;
    String RS;
    String LS;
    String AS;
    String WS;
    String amountService;
    String Sum;
    /**
     * Creates new form BillPrint
     */
    public BillPrint(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
         connect();
        txtbill.setText("\t\t-: MAJESTIC Hotel :-\n");
        txtbill.setText(txtbill.getText()+"**********************************************************************************\n");
        
        txtbill.setText(txtbill.getText()+"Staff:- "+staff+"\n");
        txtbill.setText(txtbill.getText()+"Customer Details:- \n");
        txtbill.setText(txtbill.getText()+"NameID:- "+idCus+"\n");
        txtbill.setText(txtbill.getText()+"Name:- "+nm+"\n");
        txtbill.setText(txtbill.getText()+"CCCD:- "+CCCD+"\n");
        txtbill.setText(txtbill.getText()+"Mobile Number:- "+mobile+"\n");
        txtbill.setText(txtbill.getText()+"Email:- "+email+"\n");
        txtbill.setText(txtbill.getText()+"Room Service:- "+RS+"\n");
        txtbill.setText(txtbill.getText()+"Laundry Service:- "+LS+"\n");
        txtbill.setText(txtbill.getText()+"AirPot Service:- "+AS+"\n");
        txtbill.setText(txtbill.getText()+"Wakeup Service:- "+WS+"\n");
        txtbill.setText(txtbill.getText()+"Price Service:- "+amountService+"\n");
        txtbill.setText(txtbill.getText()+"**********************************************************************************\n");
        txtbill.setText(txtbill.getText()+"Room Details:- \n");
        txtbill.setText(txtbill.getText()+"Room Number:- "+roomnumber+"\n");
        txtbill.setText(txtbill.getText()+"Type:- "+type+"\n");
        txtbill.setText(txtbill.getText()+"Bed:- "+bed+"\n");
        txtbill.setText(txtbill.getText()+"Price:- "+price+"\n");
        txtbill.setText(txtbill.getText()+"Check IN Date="+indate+"\t\tNumber of Days="+days+"\n");
        txtbill.setText(txtbill.getText()+"Check OUT Date="+outdate+"\t\tTotal Day="+amount+"\n");
        txtbill.setText(txtbill.getText()+"Total Price:- "+Sum+"\n");
        txtbill.setText(txtbill.getText()+"**********************************************************************************\n");
        txtbill.setText(txtbill.getText()+"\t\t"+"                    Thank You,Please Visit Again.");
    }
public void connect(){
        PreparedStatement pst;
        ResultSet rs;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost;database=HotelSN;","sa","songlong");
            pst=con.prepareStatement("select * from Customerxy where RoomNumber=?");
            pst.setString(1,id);
            rs=pst.executeQuery();
            if(rs.next()){

                staff=rs.getString("names");
                email=rs.getString("email");
                idCus=rs.getString("idCus");
                nm=rs.getString("nameCus");
                CCCD=rs.getString("CCCD");
                mobile=rs.getString("phone");
                roomnumber=rs.getString("RoomNumber");
                bed=rs.getString("BedType");
                type=rs.getString("RoomType");
                indate=rs.getString("joindate");
                outdate=rs.getString("outdate");
                price=rs.getString("Price");
                days =rs.getString("dayx");
                amount=rs.getString("amount");
                RS=rs.getString("RoomService");
                LS=rs.getString("LaundryService");
                AS=rs.getString("Airpot");
                WS=rs.getString("Wakeup");
                amountService=rs.getString("amountService");
                Sum=rs.getString("amountSum");
            }
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void connect1(){
        PreparedStatement pst;
        ResultSet rs;
         try {
               
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=HotelSN;","sa","songlong");
                pst = con.prepareStatement("update Customerxy set status1=? where RoomNumber=?");
                pst.setString(1, "print");
                 pst.setString(2,id);
         pst.executeUpdate();
         
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtbill.setColumns(20);
        txtbill.setRows(5);
        jScrollPane1.setViewportView(txtbill);

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jButton1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          try {
            FileInputStream fis = new FileInputStream("src\\manage_hotel\\cash.mp3");
            BufferedInputStream bis = new BufferedInputStream(fis);
            Player player = new Player(bis);
            player.play();
       
        try {
            if(txtbill.print()){
                this.dispose();
                CheckOUt co = new CheckOUt(new javax.swing.JFrame(), true);
                co.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                 this.dispose();
                BillDetails bds = new BillDetails(new javax.swing.JFrame(), true);
                bds.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            connect1();
            }
        } catch (PrinterException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
       } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BillPrint dialog = new BillPrint(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtbill;
    // End of variables declaration//GEN-END:variables
}
