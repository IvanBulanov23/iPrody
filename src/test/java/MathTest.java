import org.example.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathTest {
    @Test
    void testFactorial() {
        assertEquals(1, MathUtils.factorial(0));
        assertEquals(120, MathUtils.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
    }

    @Test
    void testSquareRoot() {
        assertEquals(4.0, MathUtils.squareRoot(16.0));
        assertEquals(0.0, MathUtils.squareRoot(0.0));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.squareRoot(-5.0));
    }

    @Test
    void testPower() {
        assertEquals(8, MathUtils.power(2, 3));
        assertEquals(1, MathUtils.power(5, 0));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.power(2, -1));
    }

  /*  @Test
    void testIntentionalFailure() {
        assertEquals(1, 2);
    }*/

    @Test
    void testAverage() {
        assertEquals(2.0, MathUtils.average(new int[]{1, 2, 3}));
        assertEquals(-2.0, MathUtils.average(new int[]{-1, -3}));
        assertEquals(5.0, MathUtils.average(new int[]{5}));

        assertThrows(IllegalArgumentException.class, () -> MathUtils.average(null));
        assertThrows(IllegalArgumentException.class, () -> MathUtils.average(new int[]{}));
    }

}

