package Test;
import fraemwork.Annotation.Test;
import util.Calculator;
import fraemwork.assertions.AssertExpection;
import fraemwork.assertions.Assertions;

public class CalculatorLineTest {
    @Test
    public void testSumLine() throws AssertExpection {
        Assertions.contains(Calculator.sumLine(2, 3), "2 + 3");
    }

    @Test
    public void testDivideLine() throws AssertExpection {
        Assertions.contains(Calculator.divideLine(6, 3), "6 / 3");
    }

    @Test
    public void testMultiplyLine() throws AssertExpection {
        Assertions.contains(Calculator.multiplyLine(2, 3), "2 * 3");
    }

    @Test
    public void testSubtractLine() throws AssertExpection {
        Assertions.contains(Calculator.subtractLine(6, 3), "6 - 3");
    }
}
