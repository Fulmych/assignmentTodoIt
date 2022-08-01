package lexicon.se.model;
import lexicon.se.sequencers.TodoItemTaskIdSequencer;

import java.util.Objects;

public class TodoItemTask {
    private final int id;
    private boolean assigned;
    private TodoItem toDoItem;
    private Person assigne;

    public TodoItemTask(boolean assigned, TodoItem toDoItem, Person assigne) {
        this.assigned = assigned;
        this.toDoItem = toDoItem;
        this.assigne = assigne;
        this.id = TodoItemTaskIdSequencer.nextId();
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getToDoItem() {
        return toDoItem;
    }

    public void setToDoItem(TodoItem toDoItem) {
        this.toDoItem = toDoItem;
    }

    public Person getAssigne() {
        return assigne;
    }

    public void setAssigne(Person assigne) {
        this.assigne = assigne;
    }
    @Override
    public String toString() {
        return "TodoItemTask[" +
                "id=" + id +
                ", assigned=" + assigned +
                ", toDoItem='" + toDoItem + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id && assigned == that.assigned && Objects.equals(toDoItem, that.toDoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, toDoItem);
    }
}
