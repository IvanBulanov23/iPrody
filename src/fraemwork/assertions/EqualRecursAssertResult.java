package fraemwork.assertions;

public class EqualRecursAssertResult<T> extends AssertResult{
    T expected;
    T actual;

    public EqualRecursAssertResult(T expected, T actual, boolean success) {
        super(success);
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public String toString() {
        return null;
    }
}
