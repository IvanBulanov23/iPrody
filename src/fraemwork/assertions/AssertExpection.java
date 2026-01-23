package fraemwork.assertions;

public class AssertExpection extends Exception {
    private final AssertResult assertResult;
    public AssertExpection(AssertResult assertResult) {
        this.assertResult = assertResult;
    }
    public AssertResult getAssertResult() {
        return assertResult;
    }
}