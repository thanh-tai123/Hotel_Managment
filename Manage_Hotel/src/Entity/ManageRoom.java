/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class ManageRoom {
    String RoomNumber;
    String Price;
    String RoomType,BedType, Status1;

    public ManageRoom() {
    }

    public ManageRoom(String RoomNumber, String Price, String RoomType, String BedType, String Status1) {
        this.RoomNumber = RoomNumber;
        this.Price = Price;
        this.RoomType = RoomType;
        this.BedType = BedType;
        this.Status1 = Status1;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public String getBedType() {
        return BedType;
    }

    public void setBedType(String BedType) {
        this.BedType = BedType;
    }

    public String getStatus1() {
        return Status1;
    }

    public void setStatus1(String Status1) {
        this.Status1 = Status1;
    }

    
            
}
