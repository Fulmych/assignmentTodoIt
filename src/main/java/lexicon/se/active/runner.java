package lexicon.se.active;

import lexicon.se.data_access.PersonDAOList;
import lexicon.se.data_access.TodoItemDAOList;
import lexicon.se.data_access.TodoItemTaskDAOList;
import lexicon.se.model.*;

import java.time.LocalDate;

public class runner {
    public static void main(String[] args) {
        PersonDAOList pL = new PersonDAOList();
        TodoItemDAOList iL = new TodoItemDAOList();
        TodoItemTaskDAOList tL = new TodoItemTaskDAOList();
        Person lars = new Person("Lars", "Berg", "lars.berg@mail.com", "Lasse", "Högrev", AppRole.ROLE_APP_ADMIN);
        Person anders = new Person("Anders", "Park", "anders.park@mail.com", "And", "Banan", AppRole.ROLE_APP_USER);
        TodoItem car = new TodoItem("Car Washing", "Washing the car.", LocalDate.parse("2022-12-24"), false, lars, LocalDate.now());
        TodoItemTask carWashing = new TodoItemTask(true, car, lars);
        pL.persist(lars);
        pL.persist(anders);
        iL.persist(car);
        tL.persist(carWashing);
        System.out.println("All members = " + pL.findAll());
        System.out.println("Car = " + iL.findAll());
        System.out.println("Car washing = " + tL.findAll());
//        files.writeObjectToFile(pL.findAll());
    }
}
