package DataLayer.DAO;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManagement {

    public <T> boolean saveToFile(List<T> list, String fileName, String msg) {
        File f = new File(fileName);
        if (!f.exists()) {
            return false;
        }
        try {
            ObjectOutputStream o;
            try (FileOutputStream fos = new FileOutputStream(f)) {
                o = new ObjectOutputStream(fos);
                for (T item : list) {
                    o.writeObject(item);
                }
            }
            o.close();
            System.out.println(msg);
            return true;        // Indicates a successful save
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public <T> boolean loadFromFile(List<T> list, String fileName) {
        try {
            // check file exists
            File f = new File(fileName);
            if (!f.exists()) {
                return false;
            }
            ObjectInputStream oi;
            try ( // read file
                    FileInputStream fis = new FileInputStream(f)) {
                oi = new ObjectInputStream(fis);
                if (f.length() == 0) {
                    System.err.println("File is empty");
                }   boolean check = true;
                while (check) {
                    try {
                        T c = (T) oi.readObject();
                        list.add(c);
                    } catch (EOFException e) {
                        break;
                    }
                }
            }
            oi.close();
        } catch (FileNotFoundException e) {
            // log error or throw exception
            System.err.println("File not found: " + fileName);
            return false;
        } catch (IOException | ClassNotFoundException e) {
            // log error or throw exception
            System.err.println("Error reading from file: " + fileName + e);
            return false;
        } catch (NumberFormatException e) {
            // log error or throw exception
            System.err.println("Error parsing double value from input: " + e.getMessage());
            return false;
        }
        return true;
    }

}
