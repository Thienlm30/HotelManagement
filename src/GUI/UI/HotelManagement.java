
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
        menu.addOption("Others Quit");
        
        HotelService h = new HotelService("./Hotel.dat");
        
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
                    h.updateHotel();
                    break;
                case 4:
                    h.deleteHotel();
                    break;
                case 5:
                    h.searchHotel();
                    break;
                case 6:
                    h.display();
                    break;
                default:
                    System.out.println("Bye Bye!");
                    break;
            }  
        } while (choice > 0 && choice < 7);

    }
    
}
