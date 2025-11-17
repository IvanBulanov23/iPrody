import Task1.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Figures[] figures = {
                new Circle(8.0),
                new Square(10.0),
                new Triangle(10, 12, 15),
                new Circle(10.0),
                new Square(40.5)
        };
        double area = AreaCalculation.areaCalculation(figures);
        System.out.printf("%.2f%n", area);



    }
}
