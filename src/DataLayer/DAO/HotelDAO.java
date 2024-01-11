
package DataLayer.DAO;

import Bussiness.DTO.Hotel;
import java.util.List;

/**
 * This class contain function to access data of Hotel in file
 * @author Thienlm30
 */
public class HotelDAO {
    
    
    public HotelDAO() {
    }
    
    public static boolean loadFromFile(List<Hotel> listFile ,String fileName){
        //listFile.clear();
        return FileManagement.loadFromFile(listFile, fileName);
    }
    
    public static boolean saveToFile(List<Hotel> listBuffer, String fileName, String msg){
        return FileManagement.saveToFile(listBuffer, fileName, msg);
    }
    
    
    
}
