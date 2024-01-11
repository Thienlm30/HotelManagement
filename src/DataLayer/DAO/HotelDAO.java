
package DataLayer.DAO;

import Bussiness.DTO.Hotel;
import java.util.List;

/**
 * This class contain function to access data of Hotel in file
 * @author Thienlm30
 */
public class HotelDAO {
    
    /**
     * This function load data of Hotel from file
     * @param list
     * @param fileName
     * @return 
     */
    public static boolean loadFromFile(List<Hotel> list ,String fileName){
        //listFile.clear();
        return FileManagement.loadFromFile(list, fileName);
    }
    
    /**
     * This function write data of Hotel to file
     * @param list
     * @param fileName
     * @param msg
     * @return 
     */
    public static boolean saveToFile(List<Hotel> list, String fileName, String msg){
        return FileManagement.saveToFile(list, fileName, msg);
    }
    
    
    
}
