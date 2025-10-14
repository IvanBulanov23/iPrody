import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        replacingTheMethod(new int[]{0, 1, 1, 1, 1, 0, 0});
        creating_an_array();
        array_multiplication(new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        filling_the_diagonal();
        filling_the_diagonal2();
        filling_the_array(6, 7);
        searching_for_array_boundaries (new int[] {-1, 5, -3, 2, 9, 4, 5, 2, 4, 8, 9, 1});

    }

    public static void replacingTheMethod(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }

        }

        System.out.println(Arrays.toString(array));
    }
    public static void creating_an_array (){
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i]=i++;
        }

        System.out.println(Arrays.toString(array));

    }
    public static void array_multiplication(int [] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] < 6)
                array[i]*=2;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void filling_the_diagonal (){
        int [][] array = new int [5] [5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }

                System.out.print(array[i][j]);
            }

            System.out.println();
        }

    }
    public static void filling_the_diagonal2 () {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array[i].length - 1) {
                    array[i][j] = 1;
                }

                System.out.print(array[i][j]);
            }

            System.out.println();
        }
    }
    public static void filling_the_array (int len, int initialValue){
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i]=initialValue;
        }
        System.out.println(Arrays.toString(array));

    }

    public static void searching_for_array_boundaries (int[] array){
        Arrays.sort(array);
        System.out.println("min value = " + array[0]);
        System.out.println("max value = " + array[array.length - 1]);

    }

}