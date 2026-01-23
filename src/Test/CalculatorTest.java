package Test;
import fraemwork.Annotation.Test;
import util.Calculator;
import fraemwork.assertions.AssertExpection;
import fraemwork.assertions.Assertions;

public class CalculatorTest {
    @Test
    public void testSum() throws AssertExpection {
        Assertions.equals(6L, Calculator.sum(2, 3));
    }

    @Test
    public void testDivide() throws AssertExpection {
        Assertions.equals(2.0, Calculator.divide(6, 3));
    }

    @Test
    public void testSubtract() throws AssertExpection {
        Assertions.equals(3, Calculator.subtract(6, 3));
    }

    @Test
    public void testMultiply() throws AssertExpection {
        Assertions.equals(18L, Calculator.multiply(6, 3));
    }
}
