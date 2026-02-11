import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraysUtilTest {
    private final ArraysUtil arraysUtil = new ArraysUtil();

    @Test
    public void standartArraysUtil() {
        int[] actual = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {5, 6, 7};
        Assertions.assertArrayEquals(expected, arraysUtil.arrayLast(actual));
    }

    @Test
    public void lastArrayUtil() {
        int[] actual = {1, 2, 3, 4, 5, 6, 4};
        int[] expected = new int[0];
        Assertions.assertArrayEquals(expected, arraysUtil.arrayLast(actual));
    }

    @Test
    public void notArrayUtil() {
        int[] actual = new int[0];
        Assertions.assertThrows(RuntimeException.class, () -> {
            arraysUtil.arrayLast(actual);
        });

    }

    @Test
    public void notFourArrayUtil() {
        int[] actual = {1, 2, 3, 5, 6};
        Assertions.assertThrows(RuntimeException.class, () -> {
            arraysUtil.arrayLast(actual);
        });
    }

    @Test
    public void standartArraysOnly() {
        int[] actual = {1, 4, 1, 4, 4, 4, 4, 1};
        Assertions.assertTrue(arraysUtil.arrayOnly(actual));
    }

    @Test
    public void notFourArrayOnly() {
        int[] actual = {1, 1, 1, 1, 1};
        Assertions.assertFalse(arraysUtil.arrayOnly(actual));
    }

    @Test
    public void notOneArrayOnly() {
        int[] actual = {4, 4, 4, 4, 4};
        Assertions.assertFalse(arraysUtil.arrayOnly(actual));
    }
    @Test
    public void notArrayOnly() {
        int[] actual = new int[0];
        Assertions.assertFalse(arraysUtil.arrayOnly(actual));
    }
}
