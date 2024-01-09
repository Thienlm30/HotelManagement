
package Bussiness.Service;

import Bussiness.Components.DataValuation;
import Bussiness.Components.SearchData;
import Bussiness.DTO.Hotel;
import DataLayer.DAO.HotelDAO;
import GUI.Uitilities.MyUitil;
import java.util.ArrayList;
import java.util.List;

public class HotelService implements IHotelService{
    
    private List<Hotel> listBuffer = new ArrayList<>();
    private List<Hotel> listFile = new ArrayList<>();

    public HotelService() {
        HotelDAO h = new HotelDAO();
        try {        
            h.loadFromFile(listFile, "Hotel.dat");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        if(listFile.isEmpty()) {
            System.out.println("Empty file, add a new one");
            addHotel();
        }
    }
    
//    public void loadData() {
//        
//    }

    // public void loadData() {
    //     try {
    //         HotelDAO.loadDataFromFile(listFile, "Hotel.dat");
    //     } catch (Exception e) {
    //         System.err.println(e.getMessage());
    //     }
    // }
    
    @Override
    public void addHotel() {
        String id, name, address, phone;
        int room, rate;
        do {
            System.out.println("Please enter new hotel information!");
            id = DataValuation.inputID(listBuffer, listFile);
            name = DataValuation.inputName();
            room = DataValuation.inputRoom();
            address = DataValuation.inputAddress();
            phone = DataValuation.inputPhone();
            rate = DataValuation.inputRate();
            listBuffer.add(new Hotel(id, name, room, address, phone, rate));
        } while (MyUitil.getYN("Do you want to add new Hotel? (Y/N): "));
    }
    
    // check by ID
    @Override
    public void checkExitHotel(){
        String id;
        do {
            id = MyUitil.getPatternString("Enter ID like Hxx (x is a number): ", 
                    "ID must be Hxx (x is a number)", "H\\d{2}");
            if (!SearchData.searchById(listBuffer, listFile, id)) 
                System.out.println("No Hotel Found!");
            else System.out.println("Exist  Hotel");
        } while (MyUitil.getYN("Do you want to search hotel? (Y/N): "));
    }

    @Override
    public void updateHotel() {
        
    }

    @Override
    public void deleteHotel() {
        
    }

    @Override
    public void searchHotel() {
        
    }

    @Override
    public void display() {
        
    }
    
    public void saveToFile() {
        HotelDAO hd = new HotelDAO();
        hd.saveToFile(listBuffer, "Hotel.dat", "Saved successfully!");
    }
    
}
