package Task1;

public class Triangle implements Figures {
    private double sideA, sideB, sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 || sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Данные стороны не могут образовывать треугольник");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private double semiperimeter() {
        return (sideA + sideB + sideC) / 2.0;
    }

    @Override
    public double areaCalculation() {
        return Math.sqrt(semiperimeter() * (semiperimeter() - sideA) * (semiperimeter() - sideB) * (semiperimeter() - sideC));
    }

}
