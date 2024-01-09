
package DataLayer.DAO;

import Bussiness.DTO.Hotel;
import java.util.List;

public class HotelDAO {
    
    private final FileManagement fm;

    public HotelDAO() {
        fm = new FileManagement();
    }
    
    public boolean loadDataFromFile(List<Hotel> hotel ,String fName){
        return fm.loadFromFile(hotel, fName);
    }
    
    public boolean saveDataFromFile(List<Hotel> hotel,String fName){
        return fm.saveToFile(hotel, fName, "Product save file successfull!");
    }
    
    
    
}
