package Bussiness.Service;

import Bussiness.Components.DataValuation;
import Bussiness.Components.SearchData;
import Bussiness.DTO.Hotel;
import DataLayer.DAO.HotelDAO;
import GUI.UI.Menu;
import GUI.Uitilities.MyUitil;
import java.util.ArrayList;
import java.util.List;

public class HotelService implements IHotelService {

    //private List<Hotel> listBuffer = new ArrayList<>();
    private List<Hotel> listFile = new ArrayList<>();
    private String pathFile;

    public HotelService(String fileName) {
        this.pathFile = fileName;
        try {
            HotelDAO.loadFromFile(listFile, pathFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        if (listFile.isEmpty()) {
            System.out.println("Empty file, add a new one");
            addHotel();
        }
    }
    
    /**
     * This function will add new Hotel to file
     * If Hotel_id already exit -> Error: ID duplicated
     */
    @Override
    public void addHotel() {
        String id, name, address, phone;
        int room, rate;
        do {
            System.out.println("Please enter new hotel information!");
            id = DataValuation.inputID(listFile);
            name = DataValuation.inputName();
            room = DataValuation.inputRoom();
            address = DataValuation.inputAddress();
            phone = DataValuation.inputPhone();
            rate = DataValuation.inputRate();
            listFile.add(new Hotel(id, name, room, address, phone, rate));
            saveToFile();
        } while (MyUitil.getYN("Do you want to add new Hotel? (Y/N): "));
    }

    /**
     * This function check if Hotel exit or not by Hotel_id from User
     */
    @Override
    public void checkExitHotel() {
        String id;
        do {
            id = MyUitil.getPatternString("Enter ID like Hxx (x is a number): ",
                    "ID must be Hxx (x is a number)", "H\\d{2}");
            if (!SearchData.searchById(listFile, id)) {
                System.out.println("No Hotel Found!");
            } else {
                System.out.println("Exist  Hotel");
            }
        } while (MyUitil.getYN("Do you want to search hotel? (Y/N): "));
    }

    /**
     * This function allow User update information of Hotel
     * If new information is blank, then do not update
     */
    @Override
    public void updateHotel() {
        String id, name, address, phone, roomS, rateS;
        int room, rate;
        id = MyUitil.getPatternString("Enter ID like Hxx (x is a number): ",
                "ID must be Hxx (x is a number)", "H\\d{2}");
        if (!SearchData.searchById(listFile, id)) {
            System.out.println("No Hotel Found!");
        } else {
            Hotel h = SearchData.searchHotelById(listFile, id);

            name = MyUitil.getStrCanBlank("Enter new name: ");
            if (name.matches("\\s+") || name.length() == 0) {
                name = h.getName();
            } else {
                name = MyUitil.normolizeStr(name);
            }

            roomS = MyUitil.getStrCanBlank("Enter new available room: ");
            if (roomS.matches("\\s+") || roomS.length() == 0) {
                room = h.getRoomAvailable();
            } else if (roomS.matches("\\d+")) {
                room = Integer.parseInt(roomS);
            } else {
                room = DataValuation.inputRoom();
            }

            address = MyUitil.getStrCanBlank("Enter new address: ");
            if (address.matches("\\s+") || address.length() == 0) {
                address = h.getAddress();
            } else {
                address = MyUitil.normolizeStr(address);
            }

            phone = MyUitil.getStrCanBlank("Enter new phone: ");
            if (phone.trim().length() == 0) {
                phone = h.getPhone();
            } else if (!(phone.matches("0\\d{9}"))) {
                System.err.println("Phone number must have ten number");
                phone = MyUitil.getPatternString("Enter hotel phone number (0xx... - ten number): ",
                        "Phone number must have ten number", "0\\d{9}");
            }

            rateS = MyUitil.getStrCanBlank("Enter new rate: ");
            if (rateS.matches("\\s+") || rateS.length() == 0) {
                rate = h.getRating();
            } else {
                rate = Integer.parseInt(rateS);
                if (rate < 1 || rate > 6) {
                    rate = MyUitil.getInteger("Enter rating (1...6 star): ",
                            "Rating must an integer from 1 to 6 star", 1, 6);
                }
            }

            if (SearchData.searchHotelById(listFile, id) != null) {
                h.setName(name);
                h.setAddress(address);
                h.setPhone(phone);
                h.setRating(rate);
                h.setRoomAvailable(room);
                saveToFile();
                List<Hotel> listOut = new ArrayList<>();
                listOut.add(h);
                printFormat(listOut);
            }
        }

    }

    /**
     * This function allow User delete Hotel information
     * And ask to sure that User want to delete
     */
    @Override
    public void deleteHotel() {
        String id;
        id = MyUitil.getPatternString("Enter ID like Hxx to delete: ",
                "ID must be Hxx (x is a number)", "H\\d{2}");
        Hotel h = SearchData.searchHotelById(listFile, id);
        if (h == null) {
            System.out.println("No Hotel Found");
        } else if (MyUitil.getYN("Do you ready want to delete this hote? (Y/N)")) {
            listFile.remove(h);
            saveToFile();
        }
    }

    /**
     * This function is a sub-menu
     * This allow User search Hotel information by ID or Name
     */
    @Override
    public void searchHotel() {
        Menu menu = new Menu("Searching Hotel");
        menu.addOption("Searching by Hotel_id");
        menu.addOption("Searching by Hotel_name");
        menu.addOption("Quit");

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            List<Hotel> listBuffer ;
            switch (choice) {
                case 1:
                    String id = MyUitil.getPatternString("Enter ID to search (Hxx): ", 
                            "ID must be Hxx (x is a number)", "H\\d{2}");
                    
                    HotelDAO.loadFromFile(listFile, pathFile);
                    listBuffer = new ArrayList<>();
                    
                    listBuffer.add(SearchData.searchHotelById(listFile, id));
                    printFormat(listBuffer);
                    
                    break;
                case 2:
                    String name = MyUitil.getNonBlankString("Enter nanme to search: ",
                            "Name can be blank");
                    name = MyUitil.normolizeStr(name);
                    
                    listBuffer = new ArrayList<>();           
                    HotelDAO.loadFromFile(listFile, pathFile);
                    
                    for (Hotel h : listFile) {
                       if (h.getName().toLowerCase().contains(name.toLowerCase())) 
                           listBuffer.add(h);
                    }
                    listBuffer.sort((h2,h1) -> h2.getId().compareToIgnoreCase(h1.getId()));
                    printFormat(listBuffer);
                    break;
                default:
                    System.out.println("Return to main menu");
                    break;
            }
        } while (choice > 0 && choice < 3);

    }

    /**
     * This function will display all Hotel information and desc by Name
     */
    @Override
    public void display() {
        try {
            HotelDAO.loadFromFile(listFile, pathFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        if (listFile.isEmpty()) {
            System.out.println("No Hotel Found");
            return;
        }
        listFile.sort((h1, h2) -> h2.getName().compareToIgnoreCase(h1.getName()));
        printFormat(listFile);
    }
    
    /**
     * This function only use for this class
     * This will save data from list to file
     */
    private void saveToFile() {
        HotelDAO.saveToFile(listFile, pathFile, "Saved to file successfully!");
        //h.loadFromFile(listFile, pathFile);
    }
    
    /**
     * This function only use for this class 
     * This will print all Hotel information from parameter list
     * @param list list of Hotel to print
     */
    private void printFormat(List<Hotel> list) {
        for (int i = 0; i < 118; i++) {
            System.out.printf("-");
        }
        System.out.println("");
        //
        //
        System.out.printf("| ID |%8s%4s%8s|Room Available|%25s%7s%25s|   Phone  |Rating|\n", " ", "Name", " ", " ", "Address", " ", "Phone", "Rating");
        for (int i = 0; i < 118; i++) {
            System.out.printf("-");
        }
        System.out.println("");
        //
        //
        for (Hotel h : list) {
            System.out.println(h.toString());
        }
        //
        //
        for (int i = 0; i < 118; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
