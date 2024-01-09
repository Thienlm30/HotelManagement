
package Bussiness.Components;

import Bussiness.DTO.Hotel;
import java.util.List;

public class SearchData {
    
    // true: exit
    public static boolean searchById(List<Hotel> listBuffer, List<Hotel> listFile, String id) {
        for (Hotel h : listBuffer) {
            if (id.equalsIgnoreCase(h.getId())) return true;
        }
        for (Hotel h : listFile) {
            if (id.equalsIgnoreCase(h.getId())) return true;
        }
        return false;
    }
    
}
