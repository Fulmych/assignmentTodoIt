package lexicon.se.active;

import lexicon.se.model.Person;

import java.io.*;

public class files {
    private static final String filePath = "C:/objects.json";
    public static void writeObjectToFile(Object serObj){
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Object readFileToObject(Person person){
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            person = (Person) objectIn.readObject();
            objectIn.close();
            return person;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
