package Task1;

public class Circle implements Figures{
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным.");
        }
        this.radius = radius;
    }

    @Override
    public double areaCalculation() {
        return Math.PI * radius * radius;
    }

}
