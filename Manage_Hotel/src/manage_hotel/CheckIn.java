/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package manage_hotel;

import Utils.Auth;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import org.junit.Test;

/**
 *
 * @author Admin
 */
public class CheckIn extends javax.swing.JDialog {
private static final String P_EMAIL="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
    /**
     * Creates new form CheckIn
     */
    public CheckIn(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        SimpleDateFormat  dat=new SimpleDateFormat("yyyy-MM-dd ");
         Date d=new Date();
         txtDate.setText(dat.format(d));
         txtName.requestFocus();
         set();
          txtNhanVien.setText(""+ Auth.user.getNames());
//         
    }


    public void set() {
    PreparedStatement pst;
    ResultSet rs;
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=HotelSN;", "sa", "songlong");
        pst = con.prepareStatement("select RoomNumber from roomxy where status1=? AND RoomType=? AND BedType=?");
        pst.setString(1, "Not Booking");
        pst.setString(2, cboRoomType.getItemAt(cboRoomType.getSelectedIndex()));
        pst.setString(3, cboBed.getItemAt(cboBed.getSelectedIndex()));
        rs = pst.executeQuery();
        cboRoomNumber.removeAllItems(); // Xóa tất cả các mục trong ComboBox
        while (rs.next()) {
            cboRoomNumber.addItem(rs.getString("RoomNumber")); // Thêm mục mới vào ComboBox
        }
        
        // Lắng nghe sự kiện khi giá trị được chọn trong ComboBox thay đổi
        cboRoomNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement pst;
    ResultSet rs;
                try {
                    pst = con.prepareStatement("select Price from roomxy where RoomNumber=?");
                    pst.setString(1, cboRoomNumber.getItemAt(cboRoomNumber.getSelectedIndex()));
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        txtPirce.setText(rs.getString("Price")); // Cập nhật giá trị trong trường văn bản
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}
    @Test
void reset(){
//    txtAdress.setText("");
    txtCCCD.setText("");
    txtCodeName.setText("");
    txtEmail.setText("");
    txtName.setText("");
//    txtNation.setText("");
    txtPhone.setText("");
    txtPirce.setText("");
    cboRoomNumber.setSelectedItem(null);
     cbAir.setSelected(false);
    cbLau.setSelected(false);
    cbRoomService.setSelected(false);
    cbWa.setSelected(false);
//    txtPirce.setText("");
    
//    cbAir.setText("");
//    cbLau.setText("");
//    cbRoomService.setText("");
//    cbWa.setText("");
}
    @Test   
boolean validaate(){
    String Code=txtCodeName.getText();
    String id=txtCCCD.getText();
    String phone=txtPhone.getText();
    String email = txtEmail.getText().trim();
    Matcher matcher = Pattern.compile(P_EMAIL).matcher(txtEmail.getText());
    if(!Code.startsWith("C")){
            JOptionPane.showMessageDialog(this,"Start with 'C' ");
            return false;
        }
    else if(txtName.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Fill Name");
        txtName.requestFocus();
        return false;
    }else if(txtPhone.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Fill Phone");
        return false;
    }else if(!phone.matches("0\\d{9}")){
        JOptionPane.showMessageDialog(this,"Fill Phone Only 10 Digital and 0 is Start ");
        return false;
    }
    else if(txtCCCD.getText().equals("")){
         JOptionPane.showMessageDialog(this,"Fill ID");
         return false;
    }
    else if(!id.matches("\\d{10}|\\d{12}")){
        JOptionPane.showMessageDialog(this,"Fill ID Only 10 or 12 Digital");
        return false;
    }else if (email.isEmpty()) {
    
    return true;
}
    else if(!matcher.matches()){
             JOptionPane.showMessageDialog(this, "Email is not good");
           return false;
        }
    return true;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        btnCapcha = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        txtBook = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPirce = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboRoomNumber = new javax.swing.JComboBox<>();
        cboGender = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboBed = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboRoomType = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodeName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbRoomService = new javax.swing.JCheckBox();
        cbLau = new javax.swing.JCheckBox();
        cbAir = new javax.swing.JCheckBox();
        cbWa = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtNhanVien = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();

        jRadioButton1.setText("Room Service");

        jRadioButton2.setText("Laundry Service");

        jRadioButton3.setText("jRadioButton3");

        btnCapcha.setText("Code Cus");
        btnCapcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapchaActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        txtBook.setEditable(false);
        txtBook.setText("Booking");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Email ( NOT REQURIED )");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Status");

        txtPirce.setEditable(false);

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Price");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Phone");

        cboRoomNumber.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboRoomNumberItemStateChanged(evt);
            }
        });

        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boy ", "Girl" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Room Number");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Gender");

        cboBed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Queen-Size Bed", "King-Size Bed", "Grand-King Size Bed", "Twin-Bed" }));
        cboBed.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboBedItemStateChanged(evt);
            }
        });
        cboBed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBedActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Bed Type");

        cboRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single Room", "Double Room", "Luxury Room", "VIP Room", "Twin Room." }));
        cboRoomType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboRoomTypeItemStateChanged(evt);
            }
        });
        cboRoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRoomTypeActionPerformed(evt);
            }
        });

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Code Name");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Room Type");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Check In Date");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Check In");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        cbRoomService.setText("Room Service");

        cbLau.setText("Laundry Service");

        cbAir.setText("Airpot Shuttle");

        cbWa.setText("Wake-Up Service");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 0, 51));
        jLabel15.setText("SERVICES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbAir, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(cbRoomService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbLau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbWa, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRoomService)
                    .addComponent(cbLau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAir)
                    .addComponent(cbWa))
                .addGap(72, 72, 72))
        );

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Check In Now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtNhanVien.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("CCCD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(441, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(367, 367, 367))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCodeName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(txtCCCD)))
                            .addComponent(jLabel11))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel14)
                                    .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(258, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPirce, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(cboBed, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(cboRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDate)
                            .addComponent(txtCodeName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboBed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPirce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         PreparedStatement pst;
            ResultSet rs;
        if(validaate()){
            try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost;database=HotelSN;","sa","songlong");
            pst=con.prepareStatement("select * from Customerxy where idCus=?");
            pst.setString(1, txtCodeName.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(this,"Duplicate Code Customer");
            }
            else{
            try {
           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con=DriverManager.getConnection("jdbc:sqlserver://localhost;database=HotelSN;","sa","songlong");
            pst=con.prepareStatement("insert into Customerxy(nameCus,phone,email,gender,names,joindate,RoomNumber,BedType,RoomType,Price,status1,idCus,CCCD,RoomService,LaundryService,Airpot,Wakeup)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, txtName.getText());
            pst.setString(2, txtPhone.getText());
            pst.setString(3, txtEmail.getText().toLowerCase());
            pst.setString(4, cboGender.getItemAt(cboGender.getSelectedIndex()));
//            pst.setString(5, txtAdress.getText());
            pst.setString(5, txtNhanVien.getText());

//            pst.setString(7, txtNation.getText());
            pst.setString(6, txtDate.getText());
            pst.setString(7, (String) cboRoomNumber.getSelectedItem());
            pst.setString(8,(String) cboBed.getSelectedItem());
            pst.setString(9, (String) cboRoomType.getSelectedItem());
            pst.setString(10, txtPirce.getText());
            pst.setString(11, txtBook.getText());
            pst.setString(12, txtCodeName.getText());
            pst.setString(13, txtCCCD.getText());
            boolean airValue = cbAir.isSelected();
            pst.setBoolean(16, airValue);
//            pst.setString(12,cbAir.getText());
            boolean airLau = cbLau.isSelected();
            pst.setBoolean(15, airLau);
//            pst.setString(13,cbLau.getText());
            boolean airRoom = cbRoomService.isSelected();
            pst.setBoolean(14, airRoom);
//            pst.setString(14,cbRoomService.getText());
            boolean airWa = cbWa.isSelected();
            pst.setBoolean(17, airWa);
//            String airWa = cbWa.isSelected() ? cbWa.getText() : "";
//            pst.setString(16, airWa);
////            pst.setString(15,cbWa.getText());
        
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Booked");
            pst = con.prepareStatement("update roomxy set status1=? where RoomNumber=?");
                pst.setString(1, "Booking");
                pst.setString(2, (String)cboRoomNumber.getSelectedItem());
                pst.executeUpdate();
            reset();
            }catch(HeadlessException | ClassNotFoundException | SQLException e){
                System.out.println(e);
            }
            }
            } catch (ClassNotFoundException | SQLException ex) {
           //Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char c =evt.getKeyChar();
        if(!Character.isLetter(c) && c !=' '){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyTyped

    private void cboRoomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRoomTypeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboRoomTypeActionPerformed

    private void cboRoomTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboRoomTypeItemStateChanged
        // TODO add your handling code here:
        set();
    }//GEN-LAST:event_cboRoomTypeItemStateChanged

    private void cboBedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBedActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboBedActionPerformed

    private void cboBedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboBedItemStateChanged
        // TODO add your handling code here:
        set();
    }//GEN-LAST:event_cboBedItemStateChanged

    private void cboRoomNumberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboRoomNumberItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cboRoomNumberItemStateChanged

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        // TODO add your handling code here:
        char c =evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void btnCapchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapchaActionPerformed
        // TODO add your handling code here:
       Random random = new Random();
    int randomNumber = random.nextInt(10000) + 1; // Tạo một số ngẫu nhiên từ 1 đến 100

    String captcha = "C" + randomNumber; // Kết hợp chữ "C" với số ngẫu nhiên

    txtCodeName.setText(captcha);

    }//GEN-LAST:event_btnCapchaActionPerformed

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
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CheckIn dialog = new CheckIn(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCapcha;
    private javax.swing.JCheckBox cbAir;
    private javax.swing.JCheckBox cbLau;
    private javax.swing.JCheckBox cbRoomService;
    private javax.swing.JCheckBox cbWa;
    private javax.swing.JComboBox<String> cboBed;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboRoomNumber;
    private javax.swing.JComboBox<String> cboRoomType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtBook;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtCodeName;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPirce;
    // End of variables declaration//GEN-END:variables
}
