/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.SignUp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class SignUpDao extends KetNoiSQL {
     public boolean update(SignUp nv){
        String sql = "update userxy set passsword1 = ? where iduser = ?";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1,nv.getNames());
             stm.setString(1, nv.getPassword1());
  
//            stm.setString(3, nv.getEmail());
//          stm.setString(4, nv.getPhone());
//            stm.setString(5, nv.getBirth());
//            stm.setString(6, nv.getId());
//            stm.setString(7, nv.getSalary());
//            stm.setString(8, nv.getRole());
//            stm.setString(9,nv.getHinh());
                      stm.setString(2, nv.getIduser());
            
            int update = stm.executeUpdate();
            if(update >= 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
     public boolean update1(SignUp nv){
        String sql = "update userxy set names=?,passsword1=?,phone=?,birth=?,id=?,salary=?,role1=?, image1 =?,email=? where iduser = ?";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
         stm.setString(1, nv.getNames());
         stm.setString(2, nv.getPassword1());
          stm.setString(3, nv.getPhone());
            stm.setString(4, nv.getBirth());
            stm.setString(5, nv.getId());
            stm.setString(6, nv.getSalary());
            stm.setString(7, nv.getRole());
            stm.setString(8,nv.getHinh());
            stm.setString(9,nv.getEmail());
                      stm.setString(10, nv.getIduser());
            
            int update = stm.executeUpdate();
            if(update >= 0) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public SignUp dangNhap(String tk){
        SignUp nv = null;
        
        try {
            String sql = "select * from userxy where iduser = ?";
            
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, tk);
            
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                nv = new SignUp();
                nv.setIduser(rs.getString(1));
                nv.setNames(rs.getString(2));
                nv.setEmail(rs.getString(3));
                nv.setPassword1(rs.getString(4));
                nv.setPhone(rs.getString(5));
                nv.setId(rs.getString(6));
                nv.setSalary(rs.getString(7));
                nv.setRole(rs.getString(8));
                nv.setBirth(rs.getString(9));
                nv.setHinh(rs.getString(10));
//                nv.setHoTen(rs.getString(3));
//                nv.setVaiTro(rs.getBoolean(4));
             
            }
        } catch (Exception e) {
        }
        return nv;
    }
       public void insert(SignUp model){
        String sql="INSERT INTO userxy (iduser,names,email,passsword1,phone,birth,id,salary,role1) VALUES (?,?,?,?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getIduser(),
                model.getNames(), 
                model.getEmail(), 
                model.getPassword1(),
                   
        model.getPhone(),
        model.getBirth(),
        model.getId(),
        model.getSalary(),
        model.getRole());
//        model.getHinh());
        
//                model.getStatus());

    }

       public boolean delete(String manv){
        String sql = "delete from userxy where iduser = ?";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, manv);
            
            int delete = stm.executeUpdate();
            if(delete >= 1) return true;
        } catch (Exception e) {
        }
        return false;
    }
       public List<SignUp> selectAll(){
        String sql = "select * from userxy";
        List<SignUp> list = new ArrayList<>();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                SignUp entity=new SignUp();
                    entity.setIduser(rs.getString(1));
                    entity.setNames(rs.getString(2));
                    entity.setEmail(rs.getString(3));
                    entity.setPassword1(rs.getString(4));
                    entity.setPhone(rs.getString(5));
                    entity.setId(rs.getString(6));
//                    entity.setAddress1(rs.getString(5));
                    entity.setSalary(rs.getString(7));
//                    entity.setNationality(rs.getString(7));
                    entity.setRole(rs.getString(8));
                    entity.setBirth(rs.getString(9));
                    entity.setHinh(rs.getString(10));
//                    entity.setMi(rs.getString(9));
//                    entity.setBedType(rs.getString(10));
//                    entity.setPrice(rs.getString(11));
////                    entity.setStatus1(rs.getString(13));
//                    entity.setAmount(rs.getString(12));
//                    entity.setOutdate(rs.getString(13));
////                    entity.setBillid(rs.getString(15));
//                    entity.setDayx(rs.getString(14));
                  
                    list.add(entity);
                
            }
            
        } catch (Exception e) {
        }
        return list;
    }
        public SignUp selectById(String names){
        String sql="SELECT * FROM userxy WHERE iduser=?";
        List<SignUp> list = selectBySql(sql, names);
        return list.size() > 0 ? list.get(0) : null;
    }
    protected List<SignUp> selectBySql(String sql, Object...args){
        List<SignUp> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    SignUp entity=new SignUp();
//                    entity.setMaCD(rs.getString("MaCD"));
//                    entity.setHinh(rs.getString("Hinh"));
//                    entity.setHocPhi(rs.getDouble("HocPhi"));
//                    entity.setMoTa(rs.getString("MoTa"));
//                    entity.setTenCD(rs.getString("TenCD"));
//                    entity.setThoiLuong(rs.getInt("ThoiLuong"));
                    entity.setIduser(rs.getString("iduser"));
                    entity.setNames(rs.getString("names"));
                    entity.setEmail(rs.getString("email"));
                    entity.setPassword1(rs.getString("passsword1"));
                    entity.setPhone(rs.getString("phone"));
                    entity.setId(rs.getString("id"));
                    entity.setSalary(rs.getString("salary"));
                    entity.setRole(rs.getString("role1"));
                    entity.setBirth(rs.getString("birth"));
                    entity.setHinh(rs.getString("image1"));
                    list.add(entity);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
        
        
    }
    
}
