package lexicon.se.data_access;
import lexicon.se.model.TodoItem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemDAOList implements TodoItemDAO{
    private final List<TodoItem> todoItems = new ArrayList<>();

    @Override
    public TodoItem persist(TodoItem todoItem) {
        todoItems.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        return (TodoItem) todoItems.stream().filter(todoItem -> todoItem.getId()==id);
    }

    @Override
    public List<TodoItem> findAll() {
        return todoItems;
    }

    @Override
    public List<TodoItem> findAllByDoneStatus(boolean done) {
        return todoItems.stream().filter(todoItem -> todoItem.isDone()==done).collect(Collectors.toList());
    }

    @Override
    public List<TodoItem> findByTitleContains(String title) {
        return todoItems.stream().filter(todoItem -> todoItem.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    @Override
    public List<TodoItem> findByPersonId(int id) {
        return todoItems.stream().filter(todoItem -> todoItem.getCreator().getId()==id).collect(Collectors.toList());
    }

    @Override
    public List<TodoItem> findByDeadlineBefore(LocalDate date) {
        return todoItems.stream().filter(todoItem -> todoItem.getDeadLine().isBefore(date)).collect(Collectors.toList());
    }

    @Override
    public List<TodoItem> findByDeadlineAfter(LocalDate date) {
        return todoItems.stream().filter(todoItem -> todoItem.getDeadLine().isAfter(date)).collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        todoItems.removeIf(todoItem -> todoItem.getId() == id);
    }
}
