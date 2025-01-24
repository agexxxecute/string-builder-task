import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStringBuilder {
    private char[] stringValue;
    private int count;
    private final Stack<MyStringBuilderSnapshot> snapshots;

    public MyStringBuilder() {
        this(16);
    }

    public MyStringBuilder(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("Capacity must be a positive integer");
        }
        stringValue = new char[capacity];
        snapshots = new Stack<>();
    }

    public int length() {
        return count;
    }

    public MyStringBuilder append(char c) {
        createSnapshot();
        ensureCapacity(count + 1);
        stringValue[count++] = c;
        return this;
    }

    public MyStringBuilder append (String string){
        createSnapshot();
        if (string == null){
            string = "null";
        }
        int len = string.length();
        ensureCapacity(count + len);
        string.getChars(0, len, stringValue, count);
        count += len;
        return this;
    }

    public MyStringBuilder append (int number) {
        String numberString = Integer.toString(number);
        return append(numberString);
    }

    public String toString(){
        return new String(stringValue, 0, count);
    }

    public MyStringBuilder delete(int start, int end) {
        if(start < 0 || start > count || end < 0 || end > count || start > end){
            throw new IndexOutOfBoundsException("Invalid range");
        }
        createSnapshot();
        int deleteLen = end - start;
        if (deleteLen > 0){
            System.arraycopy(stringValue, end, stringValue, start, count - end);
            count -= deleteLen;
        }
        return this;
    }

    public MyStringBuilder undo(){
        try {
            MyStringBuilderSnapshot previous = snapshots.pop();
            this.stringValue = Arrays.copyOf(previous.getStringValue(),
                previous.getStringValue().length);
            this.count = previous.getCount();
        } catch (EmptyStackException e) {
            this.stringValue = new char[16];
            this.count = 0;
        }
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > stringValue.length){
            int newCapacity = Math.max(stringValue.length * 2, minCapacity);
            char[] newStringValue = new char[newCapacity];
            System.arraycopy(stringValue, 0, newStringValue, 0, count);
            stringValue = newStringValue;
        }
    }

    private void createSnapshot() {
        snapshots.push(new MyStringBuilderSnapshot(stringValue, count));
    }


}
