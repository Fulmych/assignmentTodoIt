package lexicon.se.active;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Scanner;

public class files {
    public static String transformObjToJsonString(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
    public static void writeObjectToFile(Object obj){
        FileWriter writer;
        try {
            writer = new FileWriter("objects.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write(transformObjToJsonString(obj));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String readFileToJsonString(){
        File file = new File("objects.json");
        String json = null;
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                json = scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
