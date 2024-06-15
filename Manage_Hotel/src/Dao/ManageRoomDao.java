/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

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
public class ManageRoomDao extends KetNoiSQL{
//     public List<ManageRoom> selectAll(){
//        String sql="SELECT * FROM roomx";
//        return selectBySql(sql);
//    }
        public List<ManageRoom> selectAll(){
        String sql = "select * from roomxy ";
        List<ManageRoom> list = new ArrayList<>();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                ManageRoom entity=new ManageRoom();
                    entity.setRoomNumber(rs.getString(1));
                    entity.setRoomType(rs.getString(2));
                    entity.setBedType(rs.getString(3));
                    entity.setPrice(rs.getString(4));
                    entity.setStatus1(rs.getString(5));
                  
                    list.add(entity);
                
            }
            
        } catch (Exception e) {
        }
        return list;
    }
        public ManageRoom selectRoom(String RoomNumber){
        String sql = "select * from roomxy where RoomNumber = ?";
        ManageRoom mr = null;
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, RoomNumber);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                mr = new ManageRoom();
                
                mr.setRoomNumber(rs.getString(1));
                mr.setRoomType(rs.getString(2));
                mr.setBedType(rs.getString(3));
                mr.setPrice(rs.getString(4));
                mr.setStatus1(rs.getString(5));
               
            }
        } catch (Exception e) {
        }
        return mr;
    }
//    protected List<ManageRoom> selectBySql(String sql, Object...args){
//        List<ManageRoom> list=new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                rs = XJdbc.query(sql, args);
//                while(rs.next()){
//                    ManageRoom entity=new ManageRoom();
//                    entity.setRoomNumber(Integer.parseInt(rs.getString("RoomNumber")));
//                    entity.setRoomType(rs.getString("RoomType"));
//                    entity.setBedType(rs.getString("BedType"));
//                    entity.setPrice(Float.parseFloat(rs.getString("Price")));
//                    entity.setStatus1(rs.getString("status1"));
//                  
//                    list.add(entity);
//                }
//            }
//            finally{
//                rs.getStatement().getConnection().close();
//            }
//        } 
//        catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        return list;
//    }
}
