import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class CheckInTest {
@Test
public void Insert() {
	
	String roomtype="";
	String numberRoom="";
	String BedRoom="";
	String PriceRoom="";
	String Status="status";
	JManageRoom jm = new JManageRoom(null, false);
	boolean ex=false;
	boolean result = jm.jButton1ActionPerformed(roomtype,numberRoom,BedRoom,PriceRoom,Status);
	assertEquals(ex,result);
}
    
}