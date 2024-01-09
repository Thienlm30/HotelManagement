package GUI.Uitilities;

import java.util.Scanner;

// Class/Libary contain functions use for many project (Utilities)
// Get Data from User in Presentation Layer
// Valuation the input data from User
public class MyUitil {

    private static Scanner sc = new Scanner(System.in);

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

    public static int getInteger(String inputMsg, String errorMsg, int min, int max) {
        int n = 0;
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

    // return String without extra space
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

    // Get pattern String Ex: ID, MSSV
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
                continue;
            }
        }
    }
}
