public class MathUtilsTest {
    @BeforeSuite
    public static void beforeSuite(){
        System.out.println("beforeSuite");
    }
    /*@BeforeSuite
    public static void beforeSuite2(){
        System.out.println("beforeSuite");
    }*/ // тест
    @Test(order = 2)
    public static void testSum(){
        if(Calculator.sum(2,5)==7){
            System.out.println("testSum2 passed");
        } else {
            System.out.println("testSum2 failed");
        }
    }
    @Test(order = 3)
    public static void testDivide(){
        if (Calculator.divide(10,5)==2){
            System.out.println("testDivide3 passed");
        } else {
            System.out.println("testDivide3 failed");
        }
    }
    @Test(order = 1)
    public static void testSubtraction(){
        if (Calculator.subtraction(10,5)==2){
            System.out.println("testSubtraction1 passed");
        } else {
            System.out.println("testSubtraction1 failed");
        }
    }

    @AfterSuite
    public static void afterSuite(){
        System.out.println("afterSuite");
    }

    /*@AfterSuite
    public static void afterSuite2() {
        System.out.println("afterSuite");
    }*/  // тест
}
