import Test.ArrayTest;
import Test.CalculatorLineTest;
import Test.CalculatorTest;
import fraemwork.assertions.AssertExpection;
import fraemwork.assertions.Assertions;
import fraemwork.assertions.EqualRecursAssertResult;
import fraemwork.printer.FilePrinter;
import fraemwork.printer.Printer;
import fraemwork.printer.StdoutPrinter;
import fraemwork.runner.ExtendedTestAutomationRunner;
import fraemwork.runner.Runner;
import fraemwork.runner.TestAutomationRunner;

import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, AssertExpection {
        Printer printer = new StdoutPrinter("yyyy-MM-dd HH:mm:ss.SSS");
        Runner runner = new TestAutomationRunner(printer);
        runner.run(List.of(CalculatorTest.class, CalculatorLineTest.class, ArrayTest.class));

        FilePrinter filePrinter = new FilePrinter("yyyy-MM-dd HH:mm:ss", Paths.get("test_results.txt"));
        Runner runnerFile = new ExtendedTestAutomationRunner(filePrinter);
        runnerFile.run(List.of(CalculatorTest.class, CalculatorLineTest.class, ArrayTest.class));
    }
}


