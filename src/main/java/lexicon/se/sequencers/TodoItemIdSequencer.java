package lexicon.se.sequencers;

public class TodoItemIdSequencer {
    private static int currentId;
    public static int nextId(){
        return TodoItemIdSequencer.currentId+=1;
    }

    public static int getCurrentId() {
        return TodoItemIdSequencer.currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemIdSequencer.currentId = currentId;
    }
}
