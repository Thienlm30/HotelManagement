
package Bussiness.Components;


import Bussiness.DTO.Hotel;
import GUI.Uitilities.MyUitil;
import java.util.List;
import java.util.Scanner;

/**
 * This class contain function to call function to input data
 * @author Thienlm30
 */
public class DataValuation {
    
    public static Scanner sc = new Scanner(System.in);
    /**
     * This function allow User enter Hotel_id and check if exit or not
     * @param listFile
     * @return Hotel_id
     */
    public static String inputID(List<Hotel> listFile) {
        String id = "";
        try {
            id = MyUitil.getPatternString("Enter ID like Hxx (x is a number): ", 
                    "ID must be Hxx (x is a number)", "H\\d{2}");
            if (SearchData.searchById(listFile, id)) 
                    throw new Exception("ID dulpicated");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return id;
    }
    
    /**
     * This function allow User enter Hotel_name
     * And remove extra space in name
     * @return 
     */
    public static String inputName() {
        return MyUitil.normolizeStr(MyUitil.getNonBlankString("Enter hotel name: ", 
                "Name cannot blank"));
    }
    
    public static int inputRoom() {
        return MyUitil.getInteger("Enter hotel available rom: ", 
                "Number of room can less than zero", 0);
    }
    
    /**
     * This function allow User enter Hotel_address
     * And remove extra space in address
     * @return 
     */
    public static String inputAddress() {
        return MyUitil.normolizeStr(MyUitil.getNonBlankString("Enter hotel address: ",
                "Address cannot blank"));
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
