import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int[] array = {3, 5, 2, 1, 4, 5};
        int[] array2 = {1, 5, 7};
        arrayCopy(array, array2);
        int[] array3 = {3, 6, 9, 10, 3, 5, 2, 4, 7};
        sortingSheker(array3);
        Car car = new Car();
        car.start();
        Employee employee = new Employee("ФИО", "email", "telephone", 19);

    }

    public static void arrayCopy (int[] array, int[] array2){ //O(n)
        int [] result = new int[array.length + array2.length];
        if (array2.length > 0) {       //1
            for (int i = 0; i < array.length; i++){  //n
                result[i] = array[i];
            }
            for (int i = 0; i < array2.length; i++){  //n
            result[i+array.length] = array2[i];
            }
        }
        else result = array;
        System.out.println(Arrays.toString(result));
    }

    public static void sortingSheker (int[] array){
        int leftIndex = 0, righIndex = array.length - 1;
        int hou;
        do {
            int tempRightIndex = righIndex;
            for (int i = leftIndex; i < tempRightIndex ; i++) {
                if (array[i] > array[i+1]){
                hou = array[i+1];
                array[i+1] = array[i];
                array[i] = hou;
                righIndex = i;
                }
            }
            if (tempRightIndex == righIndex){
                break;
            }
            int tempLeftIndex = leftIndex;
            for (int i = righIndex; i >= tempLeftIndex ; i--){
                if (array[i] > array[i+1]){
                    hou = array[i+1];
                    array[i+1] = array[i];
                    array[i] = hou;
                    leftIndex = i;
                }
            }
        }
        while (leftIndex < righIndex);
        System.out.println(Arrays.toString(array));
    }

}