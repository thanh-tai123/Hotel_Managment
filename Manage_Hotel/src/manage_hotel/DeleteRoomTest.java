package manage_hotel;

import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class DeleteRoomTest {
	private Connection connection;
	@Before
	public void setUp() {
	    try {
	        // Thiết lập kết nối cơ sở dữ liệu trước khi chạy các unit test
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=HotelSN;", "sa", "songlong");
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Test
	public void testDeleteRoom() {
	    try {
	        // Chèn dữ liệu mẫu vào bảng roomxy để test
	        PreparedStatement pst = connection.prepareStatement("INSERT INTO roomxy (RoomNumber) VALUES (?)");
	        pst.setString(1, "101");
	        pst.executeUpdate();

	        // Gọi phương thức cần test
	        deleteRoom("101");

	        // Kiểm tra xem phòng đã bị xóa thành công hay chưa
	        PreparedStatement pstCheck = connection.prepareStatement("SELECT * FROM roomxy WHERE RoomNumber = ?");
	        pstCheck.setString(1, "101");
	        ResultSet rs = pstCheck.executeQuery();
	        assertFalse(rs.next()); // Kiểm tra xem ResultSet trả về có dữ liệu hay không
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private void deleteRoom(String roomNumber) throws SQLException {
	    PreparedStatement pst = connection.prepareStatement("DELETE FROM roomxy WHERE RoomNumber = ?");
	    pst.setString(1, roomNumber);
	    pst.executeUpdate();
	}
}
