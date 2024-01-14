
package Bussiness.Components;


import Bussiness.DTO.Hotel;
import GUI.Utilities.MyUtil;

import java.util.List;


/**
 * This class contain function to call function to input data
 * @author Thienlm30
 */
public class DataValidation {

    private SearchData searchData = new SearchData();
    
    /**
     * This function allow User enter Hotel_id and check if exit or not
     * @param listFile
     * @return Hotel_id
     */
    public String inputID(List<Hotel> listFile) {
        String id = "";
        try {
            id = MyUtil.getPatternString("Enter ID like Hxx (x is a number): ", 
                    "ID must be Hxx (x is a number)", "H\\d{2}");
            if (searchData.searchById(listFile, id)) 
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
    public String inputName() {
        return MyUtil.normolizeStr(MyUtil.getNonBlankString("Enter hotel name: ", 
                "Name cannot blank"));
    }
    
    public int inputRoom() {
        return MyUtil.getInteger("Enter hotel available rom: ", 
                "Number of room can less than zero", 0);
    }
    
    /**
     * This function allow User enter Hotel_address
     * And remove extra space in address
     * @return 
     */
    public String inputAddress() {
        return MyUtil.normolizeStr(MyUtil.getNonBlankString("Enter hotel address: ",
                "Address cannot blank"));
    }
    
    public String inputPhone() {
        return MyUtil.getPatternString("Enter hotel phone number (0xx... - ten number): ", 
                "Phone number must have ten number", "0\\d{9}");
    }
    
    public int inputRate() {
        return MyUtil.getInteger("Enter rating (1...6 star): ", 
                "Rating must an integer from 1 to 6 star", 1, 6);
    }    
    
}
