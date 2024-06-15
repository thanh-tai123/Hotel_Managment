/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.*;
/**
 *
 * @author tankh
 */
public class KetNoiSQL {
    protected Connection con = null;
    public KetNoiSQL(){
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelSN";
            String username = "sa";
            String password = "songlong";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, username, password);     
        } catch (ClassNotFoundException | SQLException e) {   
        }
    }
    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            
        }
    }
}
