
package DataLayer.DAO;

import Bussiness.DTO.Hotel;
import java.util.List;

public class HotelDAO {
    
    private final FileManagement fm;
    
    public HotelDAO() {
        fm = new FileManagement();
    }
    
    public boolean loadFromFile(List<Hotel> listFile ,String fileName){
        //listFile.clear();
        return fm.loadFromFile(listFile, fileName);
    }
    
    public boolean saveToFile(List<Hotel> listBuffer, String fileName, String msg){
        return fm.saveToFile(listBuffer, fileName, msg);
    }
    
    
    
}
