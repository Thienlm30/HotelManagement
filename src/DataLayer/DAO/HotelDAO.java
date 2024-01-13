
package DataLayer.DAO;

import Bussiness.DTO.Hotel;
import java.util.List;

/**
 * This class contain function to access data of Hotel in file
 * @author Thienlm30
 */
public class HotelDAO {

    private FileManagement fm = new FileManagement();
    
    /**
     * This function load data of Hotel from file
     * @param list
     * @param fileName
     * @return 
     */
    public boolean loadFromFile(List<Hotel> list ,String fileName){
        //listFile.clear();
        return fm.loadFromFile(list, fileName);
    }
    
    /**
     * This function write data of Hotel to file
     * @param list
     * @param fileName
     * @param msg
     * @return 
     */
    public boolean saveToFile(List<Hotel> list, String fileName, String msg){
        return fm.saveToFile(list, fileName, msg);
    }
    
    
    
}
