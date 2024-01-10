
package Bussiness.Service;

import Bussiness.Components.DataValuation;
import Bussiness.Components.SearchData;
import Bussiness.DTO.Hotel;
import DataLayer.DAO.HotelDAO;
import GUI.Uitilities.MyUitil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        String id, name, address, phone;
        int room, rate;
        id = MyUitil.getPatternString("Enter ID like Hxx (x is a number): ", 
                    "ID must be Hxx (x is a number)", "H\\d{2}");
        if (!SearchData.searchById(listBuffer, listFile, id)) 
                System.out.println("No Hotel Found!");
        else {
            Hotel h = SearchData.SearchById(listBuffer, listFile, id);
            
            name = MyUitil.getStrCanBlank("Enter new name: ");
            if (name.matches("\\s+")) name = h.getName();
            else name = MyUitil.normolizeStr(name);
            
            System.out.print("Enter new room: ");
            room = Integer.parseInt(new Scanner(System.in).nextLine());
            
            
            address = MyUitil.getStrCanBlank("Enter new address: ");
            if (address.matches("\\s+")) address = h.getAddress();
            else address = MyUitil.normolizeStr(address);
            
            phone = MyUitil.getStrCanBlank("Enter new phone: ");
            if (phone.matches("\\s+")) phone = h.getPhone();
            else if (!(phone.matches("0\\d{9}"))) {
                System.err.println("Phone number must have ten number");
                phone = MyUitil.getPatternString("Enter hotel phone number (0xx... - ten number): ", 
                "Phone number must have ten number", "0\\d{9}");
            }
            
            rate = MyUitil.getStrCanBlank("Enter new rate: ");
            
            
            if (SearchData.searchById(listBuffer, id) != null) {
                listBuffer.set(listBuffer.indexOf(h), new Hotel(id, name,
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
