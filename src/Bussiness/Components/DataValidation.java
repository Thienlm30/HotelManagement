
package Bussiness.Components;


import Bussiness.DTO.Hotel;
import GUI.Utilities.DataInputter;

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
            id = DataInputter.getPatternString("Enter ID like Hxx (x is a number): ", 
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
        return DataInputter.normolizeStr(DataInputter.getNonBlankString("Enter hotel name: ", 
                "Name cannot blank"));
    }
    
    public int inputRoom() {
        return DataInputter.getInteger("Enter hotel available rom: ", 
                "Number of room can less than zero", 0);
    }
    
    /**
     * This function allow User enter Hotel_address
     * And remove extra space in address
     * @return 
     */
    public String inputAddress() {
        return DataInputter.normolizeStr(DataInputter.getNonBlankString("Enter hotel address: ",
                "Address cannot blank"));
    }
    
    public String inputPhone() {
        return DataInputter.getPatternString("Enter hotel phone number (0xx... - ten number): ", 
                "Phone number must have ten number", "0[(88)|(91)|(94)]\\d{7}");
    }
    
    public int inputRate() {
        return DataInputter.getInteger("Enter rating (1...6 star): ", 
                "Rating must an integer from 1 to 6 star", 1, 6);
    }    
    
}
