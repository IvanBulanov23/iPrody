import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(array));
        swappingPlaces(array);
        System.out.println(Arrays.toString(array));

        String[] strings = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(strings));
        swappingPlaces(strings);
        System.out.println(Arrays.toString(strings));

        List<String> stringList = arraysToList(strings);
        System.out.println(stringList);
        stringList.add("F");
        System.out.println(stringList);
        stringList.add(0, "G");
        System.out.println(stringList);


        System.out.println("--- Создание ящиков ---");
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Fruit> mixedFruitBox = new Box<>();
        appleBox1.add(new Apple(), 3);
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());

        System.out.println(appleBox1.getWeight());
        System.out.println(orangeBox1.getWeight());
        System.out.println(appleBox1.compare(orangeBox1));
        appleBox1.transfer(appleBox2);
        appleBox1.print();
        appleBox2.print();


    }

    public static <T> void swappingPlaces(T[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length - 1; i += 2) {
            T temp;
            temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }

    public static <T> List<T> arraysToList(T[] arrays) {
        return new ArrayList<>(Arrays.asList(arrays));
    }

}
