package GUI.Uitilities;

import java.util.Scanner;
/**
 * This class (libary) contain functions use for many process (Utilities)
 * Get data from User in Presentation Layer
 * Valuation the input data from User
 * @author Thienlm30
 */
public class MyUitil {

    private static Scanner sc = new Scanner(System.in);
    
    /**
     * This function allow User enter an integer
     * @param inputMsg 
     * @param errorMsg
     * @return 
     */
    public static int getInteger(String inputMsg, String errorMsg) {
        int n;
        do {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.err.println(errorMsg);
            }
        } while (true);
    }
    
    /**
     * This function allow User enter an integer in range
     * @param inputMsg
     * @param errorMsg
     * @param min LowerBound
     * @param max UpperBound
     * @return 
     */
    public static int getInteger(String inputMsg, String errorMsg, int min, int max) {
        int n;
        do {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (min > n || max < n) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        } while (true);
    }
    
    /** 
     * This function allow User enter an integer bigger than a value
     * @param inputMsg
     * @param errorMsg
     * @param min
     * @return 
     */
    public static int getInteger(String inputMsg, String errorMsg, int min) {
        int n;

        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (min >= n) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }

    }

    /**
     * This function will remove extra space
     * @param string
     * @return 
     */
    public static String normolizeStr(String string) {
        string = string.trim();
        String[] tokens = string.split("//s+");
        // split string to words
        return String.join(" ", tokens);
    }

    public static String getNonBlankString(String inputMsg, String errorMsg) {
        String string = "";
        while (true) {
            System.out.print(inputMsg);
            string = normolizeStr(sc.nextLine());
            if (string.length() == 0 || string.isEmpty()) {
                System.err.println(errorMsg);
            } else {
                return string;
            }
        }
    }
    
    public static String getStrCanBlank(String msg) {
        String string = "";
        System.out.print(msg);
        string = sc.nextLine();
        return string;
    }

    /**
     * This function allow User enter a String match the format
     * Example: ID, StudentID, Key,...
     * @param inputMsg
     * @param errorMsg
     * @param pattern the format of data User input
     * @return 
     */
    public static String getPatternString(String inputMsg, String errorMsg, String pattern) {
        String string = "";
        do {
            System.out.print(inputMsg);
            string = normolizeStr(sc.nextLine());
            if (!string.matches(pattern)) {
                System.err.println(errorMsg);
            }
        } while (!string.matches(pattern));
        return string;
    }
    
    /**
     * This function get Yes or No from User to continue or not
     * @param msg
     * @return True: Yes; False: No
     */
    public static boolean getYN(String msg) {
        String choice;
        while (true) {
            System.out.print(msg);
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                return true;
            } else if (choice.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Must be Y or N");
            }
        }
    }
}
