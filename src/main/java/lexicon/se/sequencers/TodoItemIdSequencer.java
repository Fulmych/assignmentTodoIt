package lexicon.se.sequencers;

public class TodoItemIdSequencer {
    private static int currentId;
    public static int nextId(){
        return TodoItemIdSequencer.currentId+=1;
    }

    public int getCurrentId() {
        return TodoItemIdSequencer.currentId;
    }

    public void setCurrentId(int currentId) {
        TodoItemIdSequencer.currentId = currentId;
    }
}
