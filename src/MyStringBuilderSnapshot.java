import java.util.Arrays;

public class MyStringBuilderSnapshot {
    private final char[] stringValue;
    private final int count;

    public MyStringBuilderSnapshot(char[] stringValue, int count) {
        this.stringValue = Arrays.copyOf(stringValue, stringValue.length);
        this.count = count;
    }

    public char[] getStringValue() {
        return stringValue;
    }

    public int getCount() {
        return count;
    }
}
