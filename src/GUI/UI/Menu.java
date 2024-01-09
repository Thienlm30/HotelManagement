
package GUI.UI;

import java.util.ArrayList;
import GUI.Uitilities.MyUitil;


// class Menu
public class Menu {
    
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList<String>();
    
    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addOption(String newOption) {
        // newOption valuation
        optionList.add(newOption);
    }
    
    // use for main menu and sub-menu
    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption; 
        return MyUitil.getInteger(inputMsg, errorMsg, 1, maxOption);
    }
    
    // use for main menu and sub-menu
    public void printMenu() {
        System.out.println("\n------------------------------------");
        System.out.println("Welcome to " + menuTitle);
        for (int i = 0; i<optionList.size(); i++) {
            System.out.println((i+1) + ") " + optionList.get(i) + ".");
        }
    }
    
}
