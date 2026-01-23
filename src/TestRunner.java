import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class TestRunner {
    public static void start(Class<?> testClass) throws Exception {

        Method[] declaredMethods = testClass.getDeclaredMethods();

        List<Method> beforeSuiteMethod = new ArrayList<>();
        List<Method> afterSuiteMethod = new ArrayList<>();
        List<Method> testMethod = new ArrayList<>();

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteMethod.add(method);
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteMethod.add(method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                testMethod.add(method);
            }
        }
        if (beforeSuiteMethod.size() > 1) {
            throw new RuntimeException("Больше одного метода @BeforeSuite");
        }
        if (afterSuiteMethod.size() > 1) {
            throw new RuntimeException("Больше одного метода @AfterSuite");
        }

        if (!beforeSuiteMethod.isEmpty()) {
            Method before = beforeSuiteMethod.get(0);
            before.invoke(null);
        }

        for (Method method : MathUtilsTest.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                method.invoke(null);
            }
        }

        if (!afterSuiteMethod.isEmpty()) {
            Method before = afterSuiteMethod.get(0);
            before.invoke(null);
        }
    }
}
