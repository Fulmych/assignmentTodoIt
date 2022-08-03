package lexicon.se.data_access;

import lexicon.se.model.AppRole;
import lexicon.se.model.Person;
import lexicon.se.model.TodoItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemDAOListTest {
    private final List<TodoItem> todoItems = new ArrayList<>();
    Person lars = new Person("Lars", "Berg", "lars.berg@mail.com", "Lasse", "bergen", AppRole.ROLE_APP_ADMIN);
    TodoItem a = new TodoItem("Book", "Write Book", LocalDate.parse("2022-08-05"), false, lars, LocalDate.now());

    @Test
    void persist() {
        todoItems.add(a);
        Assertions.assertEquals(1, todoItems.size());
    }

    @Test
    void findById() {
        todoItems.add(a);
        Assertions.assertEquals(a, todoItems.stream()
                .filter(todoItem -> todoItem.getId() == a.getId())
                .map(TodoItem.class::cast)
                .findAny()
                .orElse(null));
    }

    @Test
    void findAll() {
        todoItems.add(a);
        Assertions.assertEquals(todoItems, todoItems);
    }

    @Test
    void findAllByDoneStatus() {
        todoItems.add(a);
        Assertions.assertEquals(todoItems, todoItems.stream().filter(todoItem -> todoItem.isDone()==a.isDone()).collect(Collectors.toList()));
    }

    @Test
    void findByTitleContains() {
        todoItems.add(a);
        Assertions.assertEquals(todoItems, todoItems.stream().filter(todoItem -> todoItem.getTitle()==a.getTitle()).collect(Collectors.toList()));
    }

    @Test
    void findByPersonId() {
        todoItems.add(a);
        Assertions.assertEquals(todoItems, todoItems.stream().filter(todoItem -> todoItem.getCreator().getId()==a.getCreator().getId()).collect(Collectors.toList()));
    }

    @Test
    void findByDeadlineBefore() {
        todoItems.add(a);
        Assertions.assertEquals(todoItems, todoItems.stream().filter(todoItem -> todoItem.getDeadLine().isBefore(LocalDate.parse("2022-12-20"))).collect(Collectors.toList()));
    }

    @Test
    void findByDeadlineAfter() {
        todoItems.add(a);
        Assertions.assertEquals(todoItems, todoItems.stream().filter(todoItem -> todoItem.getDeadLine().isAfter(LocalDate.parse("2022-07-03"))).collect(Collectors.toList()));
    }

    @Test
    void remove() {
        todoItems.add(a);
        todoItems.removeIf(todoItem -> todoItem.getId()==a.getId());
        Assertions.assertEquals(0, todoItems.size());
    }
}