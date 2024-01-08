
package GUI.UI;

import java.util.ArrayList;


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
    
    public int getChoice() {
        
    }
    
    
}
