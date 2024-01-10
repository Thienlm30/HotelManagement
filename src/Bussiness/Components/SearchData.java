
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
    
    public static Hotel searchById(List<Hotel> list, String id) {
        for (Hotel h : list) {
            if (id.equalsIgnoreCase(h.getId())) return h;
        }
        return null;
    }
        
    public static Hotel SearchById(List<Hotel> listBuffer, List<Hotel> listFile, String id) {

        for (Hotel h : listBuffer) {
            if (h.getId().equalsIgnoreCase(id))
                return h;
        }
        
        for (Hotel h : listFile) {
            if (h.getId().equalsIgnoreCase(id))
                return h;
        }
        return null;
    }
}
