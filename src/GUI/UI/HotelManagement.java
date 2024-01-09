
package GUI.UI;

public class HotelManagement {

    public static void main(String[] args) {
        
        Menu menu = new Menu("Hotel Management");
        
        menu.addOption("Adding new Hotel");
        menu.addOption("Checking exits Hotel");
        menu.addOption("Updating Hotel information");
        menu.addOption("Deleting Hotel");
        menu.addOption("Searching Hotel");
        menu.addOption("Displaying a hotel list (descending by Hotel_Name)");
        menu.addOption("Save to file");
        menu.addOption("Others Quit");
        
        int choice = 0;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            
            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                    
                    
                default:
                    throw new AssertionError();
            }  
        } while (choice > 0 && choice < 8);
        
        
        
        
        
        
        
    }
    
}
