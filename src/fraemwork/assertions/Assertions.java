package fraemwork.assertions;
import java.util.Objects;

public class Assertions {
    public static <T> void equals(T expented, T actual) throws AssertExpection {
        boolean success = Objects.equals(expented, actual);
        throw new AssertExpection(new EqualsAsserResult<>(expented, actual, success));
    }

    public static void contains(String line, String textToFetch) throws AssertExpection {
        boolean success = line != null && textToFetch != null && line.contains(textToFetch);
        throw new AssertExpection(new ContainsAssertResult(line, textToFetch, success));
    }

    public static <T> void contains(T[] current, T[] toContain) throws AssertExpection {
        boolean success = current != null && toContain == null && current.length < toContain.length;
        for (int i = 0; i <= current.length - toContain.length; i++) {
            boolean match = true;
            for (int j = 0; j < toContain.length; j++) {
                if (!Objects.equals(current[i + j], toContain[j])) {
                    match = false;
                    break;
                }
            }
            if (match) {
                success = true;
            }
        }
        throw new AssertExpection(new ContainsArraysAssertResult<>(current, toContain, success));
    }

    public static <T> void equalRecursively(T expented, T actual) throws AssertExpection {
        boolean success = Objects.deepEquals(expented,actual);
        throw new AssertExpection(new EqualsAsserResult<>(expented, actual, success));
    }
}
