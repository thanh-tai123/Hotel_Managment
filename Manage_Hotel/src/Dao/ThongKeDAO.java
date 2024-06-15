package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql, String[] cols, Object...args){
        try {
            List<Object[]> list=new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i=0; i<cols.length; i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getService(){
        String sql = "{CALL sp_getService3}";
        String[] cols = {"Year1", "CountLaundryService", "CountRoomService","CountAirpot","CountWakeup"};
        return this.getListOfArray(sql, cols);
    }
    
    public List<Object[]> getCus(){
        String sql = "{CALL sp_Cus}";
        String[] cols = {"Staff", "Cus", "room", "jd","od"};
        return this.getListOfArray(sql, cols);
    }
    
    public List<Object[]> getStaff(int name){
        String sql = "{CALL sp_Staff (?)}";
        String[] cols = {"Staff", "CountCustomerBooked"};
        return this.getListOfArray(sql, cols,name);
    }
    
    public List<Object[]> getDoanhThu(int nam){
        String sql = "{CALL sp_DoanhThu (?)}";
        String[] cols = {"RoomNumber", "CountRoomBooked", "CountCustomerBooked",  "Total"};
        return this.getListOfArray(sql, cols, nam);
    }
}

