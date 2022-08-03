package lexicon.se.active;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lexicon.se.model.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreation {
    static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    public static String transformObjToJsonString(Object obj){
        String json;
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
    public static void writeObjectToFile(Person person){
        FileWriter writer;
        try {
            writer = new FileWriter("object_"+person.getFirstName()+".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write(transformObjToJsonString(person));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String readFileToJsonString(String name){
        Path jsonPath = Paths
                .get("object_"+name+".json")
                .toAbsolutePath();
        try {
            return Files.lines(jsonPath)
                    .reduce("", String::concat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static public Person fromJson(String json){
        try {
            return mapper.readValue(json, Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
