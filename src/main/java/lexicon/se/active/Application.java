package lexicon.se.active;

import lexicon.se.data_access.PersonDAOList;
import lexicon.se.data_access.TodoItemDAOList;
import lexicon.se.data_access.TodoItemTaskDAOList;
import lexicon.se.model.*;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        PersonDAOList pL = new PersonDAOList();
        Person lars;
        Person anders;
        if (Person.file.exists()){
            lars = FileCreation.fromJsonPerson(FileCreation.readFileToPersonJsonString("lars"));
            anders = FileCreation.fromJsonPerson(FileCreation.readFileToPersonJsonString("anders"));
        } else {
            pL = new PersonDAOList();
            lars = new Person("Lars", "Berg", "lars.berg@mail.com", "Lasse", "Högrev", AppRole.ROLE_APP_ADMIN);
            anders = new Person("Anders", "Park", "anders.park@mail.com", "And", "Banan", AppRole.ROLE_APP_USER);
        }
        pL.persist(lars);
        pL.persist(anders);
        TodoItemDAOList iL = new TodoItemDAOList();
        TodoItemTaskDAOList tL = new TodoItemTaskDAOList();
        TodoItem car = new TodoItem("Car Washing", "Washing the car.", LocalDate.parse("2022-12-24"), false, pL.findById(0), LocalDate.now());
        TodoItemTask carWashing = new TodoItemTask(true, car, pL.findById(0));
        iL.persist(car);
        tL.persist(carWashing);
        System.out.println("All members = " + pL.findAll());
        System.out.println("Car = " + iL.findAll());
        System.out.println("Car washing = " + tL.findAll());
        FileCreation.writePersonToFile(lars);
        FileCreation.writePersonToFile(anders);
        System.out.println(FileCreation.readFileToPersonJsonString("lars"));
        System.out.println(FileCreation.readFileToPersonJsonString("Anders"));
    }
}
