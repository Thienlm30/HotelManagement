package DataLayer;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * This class have funciton to save and access data of Oject from file
 * This class can be reuse in other project
 * @author Thienlm30
 */
public class FileManagement {
    
    /**
     * This function load data of Object to file
     * Can be reuse in other project
     * @param <T> Object type
     * @param list list Object
     * @param fileName
     * @return 
     */
    public <T> boolean loadFromFile(List<T> list, String fileName) {
        list.clear();
        File f = new File(fileName);
        if (!f.exists()) {
            return false;
        }
        try (FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            if (f.length() == 0) {
                System.err.println("File is empty");
            }

            boolean check = true;
            while (check) {
                try {
                    T c = (T) ois.readObject();
                    list.add(c);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            return false;
        } catch (IOException | ClassNotFoundException e) {
            if (f.length() != 0) {
                System.err.println("Error reading from file: " + fileName + " " + e.getMessage());
                return false;
            }
        } catch (NumberFormatException e) {
            // log error or throw exception
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * This function save Object to file
     * Can be reuse in other project
     * @param <T> Object type
     * @param list list Object
     * @param fileName
     * @param msg
     * @return 
     */
    public <T> boolean saveToFile(List<T> list, String fileName, String msg) {

        try {

            File f = new File(fileName);
            if (!f.exists()) {
                System.out.println("Empty list");
                return false;
            }

            ObjectOutputStream fileOut;
            try (FileOutputStream fos = new FileOutputStream(f)) {
                fileOut = new ObjectOutputStream(fos);
                for (T item : list) {
                    fileOut.writeObject(item);
                }
                fileOut.close();
                fos.close();
                System.out.println(msg);
                return true; //successful save
            }
        } catch (IOException e) {
            System.out.println(e);
            
        }
        return false;
    }

}
