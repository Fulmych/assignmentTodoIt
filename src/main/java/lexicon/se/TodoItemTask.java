package lexicon.se;
import java.util.Objects;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private String toDoItem;
    private Person assigne;
    private static int uid=0;

    public TodoItemTask(boolean assigned, String toDoItem, Person assigne) {
        this.assigned = assigned;
        this.toDoItem = toDoItem;
        this.assigne = assigne;
        this.id = uid++;
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

    public String getToDoItem() {
        return toDoItem;
    }

    public void setToDoItem(String toDoItem) {
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
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", toDoItem='" + toDoItem + '\'' +
                '}';
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
