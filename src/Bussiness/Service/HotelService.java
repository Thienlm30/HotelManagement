
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
        String id, name, address, phone, roomS, rateS;
        int room, rate = 0;
        id = MyUitil.getPatternString("Enter ID like Hxx (x is a number): ", 
                    "ID must be Hxx (x is a number)", "H\\d{2}");
        if (!SearchData.searchById(listBuffer, listFile, id)) 
                System.out.println("No Hotel Found!");
        else {
            Hotel h = SearchData.SearchById(listBuffer, listFile, id);
            
            name = MyUitil.getStrCanBlank("Enter new name: ");
            if (name.matches("\\s+") || name.length() == 0) name = h.getName();
            else name = MyUitil.normolizeStr(name);
            
            roomS = MyUitil.getStrCanBlank("Enter new available room: ");
            if (roomS.matches("\\s+") || roomS.length() == 0) room = h.getRoomAvailable();
            else if (roomS.matches("\\d+")) room = Integer.parseInt(roomS);
            else room = DataValuation.inputRoom();

            address = MyUitil.getStrCanBlank("Enter new address: ");
            if (address.matches("\\s+") || address.length() == 0) address = h.getAddress();
            else address = MyUitil.normolizeStr(address);
            
            phone = MyUitil.getStrCanBlank("Enter new phone: ");
            if (phone.matches("\\s+") || phone.length() == 0) phone = h.getPhone();
            else if (!(phone.matches("0\\d{9}"))) {
                System.err.println("Phone number must have ten number");
                phone = MyUitil.getPatternString("Enter hotel phone number (0xx... - ten number): ", 
                "Phone number must have ten number", "0\\d{9}");
            }
            
            rateS = MyUitil.getStrCanBlank("Enter new rate: ");
            if (rateS.matches("\\s+") || rateS.length() == 0) rate = h.getRating();
            else if (rateS.matches("\\d{1}")) room = Integer.parseInt(rateS);
            if (rate < 1 || rate > 6) rate = MyUitil.getInteger("Enter rating (1...6 star): ", 
                "Rating must an integer from 1 to 6 star", 1, 6);
            
            if (SearchData.searchById(listBuffer, id) != null) {
                listBuffer.set(listBuffer.indexOf(h), new Hotel(id, name,
                                room, address, phone, rate));
            }
            else if (SearchData.searchById(listFile, id) != null) {
                listFile.set(listFile.indexOf(h), new Hotel(id, name,
                                room, address, phone, rate));
            }
            
            
        }
        
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
