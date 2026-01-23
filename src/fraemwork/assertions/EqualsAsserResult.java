package fraemwork.assertions;

public class EqualsAsserResult<T> extends AssertResult {
    T expected;
    T actual;
    public EqualsAsserResult(T expected, T actual, boolean success) {
        super(success);
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-30s","current: " + expected,
                "toCurrent: " + actual );
    }
}
