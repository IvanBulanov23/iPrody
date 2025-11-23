package Task1;

public class AreaCalculation {

    public static double areaCalculation(Figures[] figures) {
        double value = 0.0;
        for (Figures figure : figures) {
            value += figure.areaCalculation();
        }
        return value;
    }
}
