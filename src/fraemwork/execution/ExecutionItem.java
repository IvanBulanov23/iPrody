package fraemwork.execution;
import fraemwork.assertions.AssertResult;

import java.lang.reflect.Method;

public class ExecutionItem {
    private final Method method;
    private final AssertResult assertResult;

    public ExecutionItem(Method method, AssertResult assertResult) {
        this.method = method;
        this.assertResult = assertResult;
    }

    public Method getMethod() {
        return method;
    }

    public AssertResult getAssertResult() {
        return assertResult;
    }

    @Override
    public String toString() {
        return "ExecutionItem{" +
                "method=" + method +
                ", assertResult=" + assertResult +
                '}';
    }
}
