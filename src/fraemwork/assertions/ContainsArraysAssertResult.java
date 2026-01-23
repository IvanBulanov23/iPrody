package fraemwork.assertions;
import java.util.Arrays;

public class ContainsArraysAssertResult<T> extends AssertResult {
    T[] current;
    T[] toCurrent;

    public ContainsArraysAssertResult(T[] current, T[] toCurrent, boolean success) {
        super(success);
        this.current = current;
        this.toCurrent = toCurrent;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-30s", "current: " + Arrays.toString(current),
                "toCurrent: " + Arrays.toString(toCurrent));
    }
}
