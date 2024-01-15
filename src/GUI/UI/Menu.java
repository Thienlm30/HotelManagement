
package GUI.UI;

import java.util.ArrayList;

import GUI.Utilities.DataInputter;



/**
 * This class execute all about Menu
 * @author Thienlm30
 */
public class Menu {
    
    private final String menuTitle;
    private final ArrayList<String> optionList = new ArrayList<>();

    
    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    /**
     * This function add option of Menu to the optionList
     * @param newOption developer will add option in main function
     */
    public void addOption(String newOption) {
        // newOption valuation
        optionList.add(newOption);
    }
    
    /**
     * This function can use for main menu and sub-menu to get choice from User
     * @return number from 1 to number of max options
     */
    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption; 
        // User must enter choice between 1 and maxOption
        return DataInputter.getInteger(inputMsg, errorMsg, 1, maxOption);
    }
    
    /**
     * This function will print Menu
     * Can be use for many menu
     */
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
        for (int i = 0; i <= getSizeMenu() + 6; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
    
    /**
     * This function will support the printMenu function
     * @return the max length of the menu
     */
    private int getSizeMenu() {
        int max = menuTitle.length() + 10; // 10 character of "Welcome to"
        for (String opt : optionList) {
            if (opt.length() > max) max = opt.length();
        }
        return max;
    }
    
    /**
     * This function will support the printMenu function
     * This will print regax after option
     * @param str
     * @param regax 
     */
    private void printRegex(String str, String regax) {
        for (int i = 0; i < (getSizeMenu() - str.length()); i++) {
            System.out.print(regax);
        }
    }
    
}
