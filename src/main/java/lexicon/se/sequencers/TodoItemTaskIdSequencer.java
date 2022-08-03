package lexicon.se.sequencers;

public class TodoItemTaskIdSequencer {
    private static int currentId;
    public static int nextId(){return TodoItemTaskIdSequencer.currentId+=1;}

    public static int getCurrentId() {
        return TodoItemTaskIdSequencer.currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemTaskIdSequencer.currentId = currentId;
    }
}
