package lexicon.se.data_access;

import lexicon.se.model.AppRole;
import lexicon.se.model.Person;
import lexicon.se.model.TodoItem;
import lexicon.se.model.TodoItemTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskDAOListTest {
    private final List<TodoItemTask> todoItemTasks = new ArrayList<>();
    Person a = new Person("Lars", "Berg", "lars.berg@mail.com", "Lasse", "bergen", AppRole.ROLE_APP_ADMIN);
    TodoItem item = new TodoItem("Book", "Write Book", LocalDate.parse("2022-08-05"), false, a, LocalDate.now());
    TodoItemTask task = new TodoItemTask(true, item, a);

    @Test
    void persist() {
        todoItemTasks.add(task);
        Assertions.assertEquals(1, todoItemTasks.size());
    }

    @Test
    void findById() {
        todoItemTasks.add(task);
        Assertions.assertEquals(task, todoItemTasks.stream()
                .filter(todoItemTask -> todoItemTask.getId()==task.getId())
                .map(TodoItemTask.class::cast)
                .findAny()
                .orElse(null));;
    }

    @Test
    void findAll() {
        todoItemTasks.add(task);
        Assertions.assertEquals(todoItemTasks, todoItemTasks);
    }

    @Test
    void findByAssignedStatus() {
        todoItemTasks.add(task);
        Assertions.assertEquals(todoItemTasks, todoItemTasks.stream().filter(todoItemTask -> todoItemTask.isAssigned()==task.isAssigned()).collect(Collectors.toList()));
    }

    @Test
    void findByPersonId() {
        todoItemTasks.add(task);
        Assertions.assertEquals(todoItemTasks, todoItemTasks.stream().filter(todoItemTask -> todoItemTask.getAssigne().getId()==task.getAssigne().getId()).collect(Collectors.toList()));
    }

    @Test
    void remove() {
        todoItemTasks.add(task);
        todoItemTasks.removeIf(todoItemTask -> todoItemTask.getId() == task.getId());
        Assertions.assertEquals(0, todoItemTasks.size());
    }
}