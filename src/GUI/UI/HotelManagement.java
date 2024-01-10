
package GUI.UI;

import Bussiness.Service.HotelService;

public class HotelManagement {

    public static void main(String[] args) {
        
        Menu menu = new Menu("The Hotel Management");
        
        menu.addOption("Adding new Hotel");
        menu.addOption("Checking exits Hotel");
        menu.addOption("Updating Hotel information");
        menu.addOption("Deleting Hotel");
        menu.addOption("Searching Hotel");
        menu.addOption("Displaying a hotel list (descending by Hotel_Name)");
        menu.addOption("Save to file");
        menu.addOption("Others Quit");
        
        HotelService h = new HotelService();
        //h.loadData();
        
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    h.addHotel();
                    break;
                case 2:
                    h.checkExitHotel();
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    h.saveToFile();
                    break;
                default:
                    System.out.println("Bye Bye!");
                    break;
            }  
        } while (choice > 0 && choice < 8);

    }
    
}
