package manage_hotel;
import org.junit.jupiter.api.Test;

import Dao.SignUpDao;
import Entity.SignUp;
import Utils.Auth;

import static org.junit.jupiter.api.Assertions.*;
public class LoginTest {
	@Test
    public void testDangNhap_WithCorrectAccountAndCorrectPassword_ShouldSetAuthUserAndOpenDialog() {
        // Arrange
        SignUpDao login = new SignUpDao();
        SignUp nhanVien = new SignUp();
        nhanVien.setPassword1("correctpassword");
        String manv = "testmanv";
        String matKhau = "correctpassword";
       

        // Act
        login.dangNhap(matKhau);

        // Assert
        assertSame(nhanVien, Auth.user);
      
    }

    @Test
    public void testDangNhap_WithIncorrectAccount_ShouldShowErrorMessage() {
        // Arrange
    	 SignUpDao login = new SignUpDao();
        String manv = "testmanv";
        String matKhau = "testmatkhau";
        

        // Act
        login.dangNhap(matKhau);

        // Assert
        assertFalse(Auth.user != null);
       
        // Verify error message is shown
    }

    @Test
    public void testDangNhap_WithIncorrectPassword_ShouldShowErrorMessage() {
        // Arrange
    	 SignUpDao login = new SignUpDao();
        SignUp nhanVien = new SignUp();
        nhanVien.setPassword1("correctpassword");
        String manv = "testmanv";
        String matKhau = "incorrectpassword";
       

        // Act
        login.dangNhap(matKhau);

        // Assert
        assertFalse(Auth.user != null);
      
        // Verify error message is shown
    }
}
