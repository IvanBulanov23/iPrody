public class Calculator {
    public static long sum (int a, int b){
        return (long) a+b;
    }
    public static long subtraction(int a, int b){
        return (long) a-b;
    }
    public static double divide(int a, int b){
        if (b == 0) throw new IllegalArgumentException("b = !0");
        return (double) a/b;
    }
    public static long multiply (int a, int b){
        return (long) a*b;
    }

}
