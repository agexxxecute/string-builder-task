import java.util.Stack;

public class Caretaker {
    private Stack<MyStringBuilderSnapshot> myStringBuilderSnapshots = new Stack<>();

    public void push(MyStringBuilderSnapshot myStringBuilderSnapshot) {
        myStringBuilderSnapshots.push(myStringBuilderSnapshot);
    }

    public MyStringBuilderSnapshot pop() {
        if (myStringBuilderSnapshots.isEmpty()) {
            return null;
        }
        return myStringBuilderSnapshots.pop();
    }
}
