package Task1;

public class Square implements Figures {
    private double side;

    public Square(double side) {
        if (side <= 0)
            throw new IllegalArgumentException("Длина стороны должна быть положительна");
        this.side = side;
    }

    @Override
    public double areaCalculation() {
        return side * side;
    }

}
