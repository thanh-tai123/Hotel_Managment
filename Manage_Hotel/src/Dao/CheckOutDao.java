/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.CheckOut;
import Entity.ManageRoom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CheckOutDao extends KetNoiSQL{
     public List<CheckOut> selectAll(){
        String sql = "select * from Customerxy where status1='Booking'";
        List<CheckOut> list = new ArrayList<>();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                CheckOut entity=new CheckOut();
                    entity.setIdCus(rs.getString(2));
                    entity.setNamess(rs.getString(1));
                    entity.setNames(rs.getString(3));
                    entity.setPhone(rs.getString(4));
                    entity.setEmail(rs.getString(5));
                    entity.setGender(rs.getString(6));
//                    entity.setAddress1(rs.getString(5));
//                    entity.setId(rs.getString(7));
//                    entity.setNationality(rs.getString(7));
                    entity.setJoindate(rs.getString(7));
                    entity.setRoomNumber(rs.getString(8));
                    entity.setRoomType(rs.getString(10));
                    entity.setBedType(rs.getString(9));
                    entity.setPrice(rs.getString(11));
//                    entity.setStatus1(rs.getString(13));
                    entity.setAmount(rs.getString(12));
                    entity.setOutdate(rs.getString(13));
//                    entity.setBillid(rs.getString(15));
                    entity.setDayx(rs.getString(14));
                  
                    list.add(entity);
                
            }
            
        } catch (Exception e) {
        }
        return list;
    }
     public List<CheckOut> selectAllSta(){
        String sql = "select RoomNumber,names,nameCus,RoomType,BedType,price,dayx,amountService,amountSum from Customerxy where status1='check out'";
        List<CheckOut> list = new ArrayList<>();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                CheckOut entity=new CheckOut();
                entity.setNamess(rs.getString(2));
                    entity.setNames(rs.getString(3));
//                    entity.setPhone(rs.getString(3));
//                    entity.setEmail(rs.getString(5));
//                    entity.setGender(rs.getString(4));
//                    entity.setAddress1(rs.getString(5));
//                    entity.setId(rs.getString(6));
//                    entity.setNationality(rs.getString(7));
//                    entity.setJoindate(rs.getString(7));
                    entity.setRoomNumber(rs.getString(1));
                    entity.setRoomType(rs.getString(4));
                    entity.setBedType(rs.getString(5));
                    entity.setPrice(rs.getString(6));
                    entity.setDayx(rs.getString(7));
//                    entity.setStatus1(rs.getString(13));
                    entity.setService(rs.getString(8));
                    entity.setSum(rs.getString(9));
                    
//                    entity.setOutdate(rs.getString(8));
//                    entity.setBillid(rs.getString(15));
                    
                  
                    list.add(entity);
                
            }
            
        } catch (Exception e) {
        }
        return list;
    }
      public CheckOut selectCO(String Names){
        String sql = "select * from Customerx where nameCus = ?";
        CheckOut co = null;
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, Names);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                co = new CheckOut();
                
                co.setNames(rs.getString(1));
                co.setPhone(rs.getString(2));
//                co.setId(rs.getString(6));
                co.setJoindate(rs.getString(8));
               
               
            }
        } catch (Exception e) {
        }
        return co;
    }
       public CheckOut selectBD(String mames){
        String sql = "select RoomNumber,names,RoomType,BedType,price,dayx,amount from xcustomer where RoomNumber=?";
        CheckOut co = null;
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, mames);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                CheckOut entity = new CheckOut();
                
               
//               entity.setRoomNumber(rs.getString(1));
//                    entity.setRoomType(rs.getString(3));
//                    entity.setBedType(rs.getString(4));
//                    entity.setPrice(rs.getString(5));
////                    entity.setStatus1(rs.getString(13));
//                    entity.setAmount(rs.getString(7));
////                    entity.setOutdate(rs.getString(8));
////                    entity.setBillid(rs.getString(15));
//                    entity.setDayx(rs.getString(6));
//                entity.setNames(rs.getString("names"));
    
               entity.setRoomNumber(rs.getString(1));
                entity.setNames(rs.getString(2));
                    entity.setRoomType(rs.getString(3));
                    entity.setBedType(rs.getString(4));
                    entity.setPrice(rs.getString(5));
//                    entity.setStatus1(rs.getString(13));
entity.setDayx(rs.getString(6));
                    entity.setAmount(rs.getString(7));
//                    entity.setOutdate(rs.getString(8));
//                    entity.setBillid(rs.getString(15));
                    
            }
        } catch (Exception e) {
        }
        return co;
        
    }
    public CheckOut selectById(String room){
        String sql="SELECT * FROM xcustomer WHERE RoomNumber=?";
        List<CheckOut> list = this.selectBySql(sql, room);
        return list.size() > 0 ? list.get(0) : null;
    }
    protected List<CheckOut> selectBySql(String sql, Object...args){
        List<CheckOut> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    CheckOut entity=new CheckOut();
                    entity.setNames(rs.getString("names"));
               entity.setRoomNumber(rs.getString("RoomNumber"));
                    entity.setRoomType(rs.getString("RoomType"));
                    entity.setBedType(rs.getString("BedType"));
                    entity.setPrice(rs.getString("price"));
//                    entity.setStatus1(rs.getString(13));
                    entity.setAmount(rs.getString("amount"));
//                    entity.setOutdate(rs.getString(8));
//                    entity.setBillid(rs.getString(15));
                    entity.setDayx(rs.getString("dayx"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<Integer> selectYears() {
        String sql="SELECT DISTINCT year(outdate) Year FROM Customerxy ORDER BY Year DESC";
        List<Integer> list=new ArrayList<>();
        try {
           ResultSet rs = XJdbc.query(sql);
           while(rs.next()){
                 list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    }


