package fraemwork.runner;

import fraemwork.Annotation.Test;
import fraemwork.assertions.AssertExpection;
import fraemwork.assertions.AssertResult;
import fraemwork.execution.Execution;
import fraemwork.execution.ExecutionItem;
import fraemwork.printer.Printer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;

public class ExtendedTestAutomationRunner implements Runner {
    private final Printer printer;

    public ExtendedTestAutomationRunner(Printer printers) {
        this.printer = printers;
    }

    @Override
    public void run(List<Class<?>> testClasses) {
        var executions = testClasses.stream().map(ExtendedTestAutomationRunner::runTestClass).toList();
        printer.write(executions);
    }

    private static Object getInstance(Class<?> testClass) {
        try {
            return testClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static Execution runTestClass(Class<?> testClass) {
        Object testClassInstance = getInstance(testClass);

        LocalDateTime startTime = LocalDateTime.now();
        var executionItems = Arrays.stream(testClass.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Test.class))
                .map(method -> runTestMethod(method, testClassInstance))
                .toList();

        LocalDateTime endTime = LocalDateTime.now();
        return new Execution(testClass, executionItems, startTime, endTime);
    }

    private static ExecutionItem runTestMethod(Method method, Object testClassInstance) {
        try {
            method.invoke(testClassInstance);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof AssertExpection assertExpection) {
                return new ExecutionItem(method, assertExpection.getAssertResult());
            }
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Error: test method " + method.getName() + " doesn't throw AssertExceptions");
    }
}


