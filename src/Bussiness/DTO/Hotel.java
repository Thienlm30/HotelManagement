
package Bussiness.DTO;

import java.io.Serializable;


// implement Serializable to be written to an "ObjectOutputStream" 
// in FileManagement class in Bussiness.Service package
public class Hotel implements Serializable, Comparable<Hotel>{
    
    private String id;
    private String name;
    private int roomAvailable;
    private String address;
    private String phone;
    private int rating;

    public Hotel() {
    }

    public Hotel(String id, String name, int roomAvailable, String address, String phone, int rating) {
        this.id = id;
        this.name = name;
        this.roomAvailable = roomAvailable;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomAvailable() {
        return roomAvailable;
    }

    public void setRoomAvailable(int roomAvailable) {
        this.roomAvailable = roomAvailable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("|%4s|%20s|%14d|%40s|%10s|%6s|", 
                id, name, roomAvailable, 
                address, phone, (rating + " star"));
    }
    
    @Override
    public int compareTo(Hotel o) {
        if (this.getId().compareTo(o.getId()) > 0){
            return 1;
        } else if (this.getId().compareTo(o.getId()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    
}
