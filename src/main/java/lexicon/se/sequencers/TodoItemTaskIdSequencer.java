package lexicon.se.sequencers;

public class TodoItemTaskIdSequencer {
    private static int currentId;
    public static int nextId(){return TodoItemTaskIdSequencer.currentId+=1;}

    public int getCurrentId() {
        return TodoItemTaskIdSequencer.currentId;
    }

    public void setCurrentId(int currentId) {
        TodoItemTaskIdSequencer.currentId = currentId;
    }
}
