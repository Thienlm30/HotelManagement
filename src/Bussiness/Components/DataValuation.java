
package Bussiness.Components;

// check duplicate input ID 

import Bussiness.DTO.Hotel;
import GUI.Uitilities.MyUitil;
import java.util.List;
import java.util.Scanner;

public class DataValuation {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static String inputID(List<Hotel> listBuffer, List<Hotel> listFile) {
        String id = "";
        try {
            id = MyUitil.getPatternString("Enter ID like Hxx (x is a number): ", 
                    "ID must be Hxx (x is a number)", "H\\d{2}");
            if (SearchData.searchById(listBuffer, listFile, id)) 
                    throw new Exception("ID dulpicated");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return id;
    }
    
    public static String inputName() {
        return MyUitil.getNonBlankString("Enter hotel name: ", "Name cannot blank");
    }
    
    public static int inputRoom() {
        return MyUitil.getInteger("Enter hotel available rom: ", 
                "Number of room can less than zero", 0);
    }
    
    public static String inputAddress() {
        return MyUitil.getNonBlankString("Enter hotel address: ",
                "Address cannot blank");
    }
    
    public static String inputPhone() {
        return MyUitil.getPatternString("Enter hotel phone number (0xx... - ten number): ", 
                "Phone number must have ten number", "0\\d{9}");
    }
    
    public static int inputRate() {
        return MyUitil.getInteger("Enter rating (1...6 star): ", 
                "Rating must an integer from 1 to 6 star", 1, 6);
    }
    
    
}
