package lexicon.se.data_access;
import lexicon.se.model.TodoItem;
import lexicon.se.model.TodoItemTask;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemTaskDAOList implements TodoItemTaskDAO{
    private final List<TodoItemTask> todoItemTasks = new ArrayList<>();

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        todoItemTasks.add(todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        return todoItemTasks.stream()
                .filter(todoItemTask -> todoItemTask.getId()==id)
                .map(TodoItemTask.class::cast)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<TodoItemTask> findAll() {
        return todoItemTasks;
    }

    @Override
    public List<TodoItemTask> findByAssignedStatus(boolean status) {
        return todoItemTasks.stream().filter(todoItemTask -> todoItemTask.isAssigned()==status).collect(Collectors.toList());
    }

    @Override
    public List<TodoItemTask> findByPersonId(int personId) {
        return todoItemTasks.stream().filter(todoItemTask -> todoItemTask.getAssigne().getId()==personId).collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        todoItemTasks.removeIf(todoItemTask -> todoItemTask.getId() == id);
    }
}
