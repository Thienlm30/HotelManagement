
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
        
        for (int i = 0; i <= getSizeMenu() + 6; i++) {
            System.out.print("-");
        }
        System.out.println("");
        System.out.print("| Welcome to " + menuTitle);
        printRegex("Welcome to" + menuTitle," ");
        System.out.println( "   |");
        for (int i = 0; i<optionList.size(); i++) {
            System.out.print( "| " + (i+1) + ") " + optionList.get(i));
            printRegex(optionList.get(i), " ");
            System.out.println(" |");
        }
    }
    
    private int getSizeMenu() {
        int max = menuTitle.length() + 10; // 10 character of "Welcome to"
        for (String opt : optionList) {
            if (opt.length() > max) max = opt.length();
        }
        return max;
    }
    
    private void printRegex(String str, String regax) {
        for (int i = 0; i < (getSizeMenu() - str.length()); i++) {
            System.out.print(" ");
        }
    }
    
}
