
package Bussiness.Components;

import Bussiness.DTO.Hotel;
import java.util.List;

/**
 * This class contain function to search Hotel 
 * @author Thienlm30
 */
public class SearchData {
    
    /**
     * 
     * @param listFile
     * @param id
     * @return True: exit
     */
    public static boolean searchById(List<Hotel> listFile, String id) {
        for (Hotel h : listFile) {
            if (id.equalsIgnoreCase(h.getId())) return true;
        }
        return false;
    }
    
    /**
     * This function return Object Hotel
     * @param listFile
     * @param id
     * @return 
     */
    public static Hotel searchHotelById(List<Hotel> listFile, String id) {
        for (Hotel h : listFile) {
            if (h.getId().equalsIgnoreCase(id))
                return h;
        }
        return null;
    }
}
