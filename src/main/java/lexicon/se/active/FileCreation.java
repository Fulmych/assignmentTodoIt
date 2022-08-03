package lexicon.se.active;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lexicon.se.model.Person;
import lexicon.se.model.TodoItem;
import lexicon.se.model.TodoItemTask;

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
    public static void writePersonToFile(Person person){
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
    public static void writeTodoItemToFile(TodoItem todoItem){
        FileWriter writer;
        try {
            writer = new FileWriter("object_"+todoItem.getTitle()+".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write(transformObjToJsonString(todoItem));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeTodoItemTaskToFile(TodoItemTask todoItemTask){
        FileWriter writer;
        try {
            writer = new FileWriter("object_task_"+todoItemTask.getToDoItem()+".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write(transformObjToJsonString(todoItemTask));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String readFileToPersonJsonString(String name){
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
    public static String readFileToTodoItemJsonString(String title){
        Path jsonPath = Paths
                .get("object_"+title+".json")
                .toAbsolutePath();
        try {
            return Files.lines(jsonPath)
                    .reduce("", String::concat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String readFileToTodoItemTaskJsonString(String taskName){
        Path jsonPath = Paths
                .get("object_task_"+taskName+".json")
                .toAbsolutePath();
        try {
            return Files.lines(jsonPath)
                    .reduce("", String::concat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static public Person fromJsonPerson(String json){
        try {
            return mapper.readValue(json, Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static public TodoItem fromJsonTodoItem(String json){
        try {
            return mapper.readValue(json, TodoItem.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static public TodoItemTask fromJsonTodoItemTask(String json){
        try {
            return mapper.readValue(json, TodoItemTask.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
