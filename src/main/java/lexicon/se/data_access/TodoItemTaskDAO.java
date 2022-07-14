package lexicon.se.data_access;

import lexicon.se.model.TodoItemTask;

import java.util.List;

public interface TodoItemTaskDAO {
    TodoItemTask persist(TodoItemTask todoItemTask);
    TodoItemTask findById(int id);
    List<TodoItemTask> findAll();
    List<TodoItemTask> findByAssignedStatus(boolean status);
    List<TodoItemTask> findByPersonId(int personId);
    void remove(int id);
}
