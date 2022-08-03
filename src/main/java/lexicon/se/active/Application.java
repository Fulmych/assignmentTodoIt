package lexicon.se.active;

import lexicon.se.data_access.PersonDAOList;
import lexicon.se.data_access.TodoItemDAOList;
import lexicon.se.data_access.TodoItemTaskDAOList;
import lexicon.se.model.*;
import java.nio.file.Path;
import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        PersonDAOList pL = new PersonDAOList();
        Person lars;
        Person anders;
        TodoItem car;
        TodoItemTask carWashing;
        Path pathLars = Path.of("object_Lars.json");
        Path pathAnders = Path.of("object_Anders.json");
        Path pathCar = Path.of("object_car.json");
        Path pathCarWashing = Path.of("object_task_Car");
        if (pathLars.isAbsolute()){
            lars = FileCreation.fromJsonPerson(FileCreation.readFileToPersonJsonString("lars"));
        } else {
            lars = new Person("Lars", "Berg", "lars.berg@mail.com", "Lasse", "Högrev", AppRole.ROLE_APP_ADMIN);
        }
        if (pathAnders.isAbsolute()){
            anders = FileCreation.fromJsonPerson(FileCreation.readFileToPersonJsonString("anders"));
        } else {
            anders = new Person("Anders", "Park", "anders.park@mail.com", "And", "Banan", AppRole.ROLE_APP_USER);
        }
        pL.persist(lars);
        pL.persist(anders);
        TodoItemDAOList iL = new TodoItemDAOList();
        TodoItemTaskDAOList tL = new TodoItemTaskDAOList();
        if (pathCar.isAbsolute()){
            car = FileCreation.fromJsonTodoItem(FileCreation.readFileToTodoItemJsonString("car"));
        } else {
            car = new TodoItem("Car Washing", "Washing the car.", LocalDate.parse("2022-12-24"), false, pL.findById(0), LocalDate.now());
        }
        if (pathCarWashing.isAbsolute()){
            carWashing = FileCreation.fromJsonTodoItemTask(FileCreation.readFileToTodoItemTaskJsonString("carWashing"));
        } else {
            carWashing = new TodoItemTask(true, car, pL.findById(0));
        }
        iL.persist(car);
        tL.persist(carWashing);
        System.out.println("All members = " + pL.findAll());
        System.out.println("Car = " + iL.findAll());
        System.out.println("Car washing = " + tL.findAll());
        FileCreation.writePersonToFile(lars);
        FileCreation.writePersonToFile(anders);
        FileCreation.writeTodoItemToFile(car);
        FileCreation.writeTodoItemTaskToFile(carWashing);
        System.out.println(FileCreation.readFileToPersonJsonString("lars"));
        System.out.println(FileCreation.readFileToPersonJsonString("Anders"));
        System.out.println(FileCreation.readFileToTodoItemJsonString("CarWashing"));
        System.out.println(FileCreation.readFileToTodoItemTaskJsonString("CarWashing"));
    }
}
