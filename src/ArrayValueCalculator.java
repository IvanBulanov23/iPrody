public class ArrayValueCalculator {

    public int doCalc(String[][] arr) throws ArraySizeException, ArrayDataException {
        if (arr == null || arr.length != 4) {
            throw new ArraySizeException("Размер массива должен быть 4x4");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new ArraySizeException("В строке " + i + " должно быть 4 элемента.");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int a = Integer.parseInt(arr[i][j]);
                    sum += a;
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Ошибка преобразования данных в ячейке [" + i + "][" + j + "]: '" + arr[i][j] + "'");
                }

            }
        }
        return sum;
    }
}
