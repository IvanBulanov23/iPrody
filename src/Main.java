// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            printThreeWords();
            checkSumSign();
            printColor();
            compareNumbers();
            System.out.println(methodFifth(10, 10));
            methodsixth(-2);
            System.out.println(methodSeventh(-2));
            methodEight("i", 5);
        }
    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign(){
        int a = 10;
        int b = -10;
        if (a+b>=0)
        {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor(){
        int value = 100;
        if (value<=0){
            System.out.println("Красный");
        }
        else if (0<value && value<=100){
            System.out.println("Желтый");
        }
        else if (value>100) {
            System.out.println("Зеленый");
        } else {
            System.out.println("Выбрано неверное значение");
        }
    }
    public static void compareNumbers() {
        int a = 10;
        int b = 10;
        if (a>=b){
            System.out.println("a>=b");
        }
        else {
            System.out.println("a<b");
        }
    }
    public static boolean methodFifth (int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    public static void methodsixth (int a){
        if (a>=0){
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }
    public static boolean methodSeventh (int a){
        if (a>0)
            return false;
        else return true;
    }
    public static void methodEight(String line, int a){
        while (a>0){
            System.out.println(line);
            a--;
        }
    }

}