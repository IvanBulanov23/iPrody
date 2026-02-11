public class ArraysUtil {
    public int[] arrayLast(int[] array) {

        if (array == null) {
            throw new RuntimeException("ArraysUtil not be empty");
        }

        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                lastIndex = i;
            }
        }

        if (lastIndex == -1) {
            throw new RuntimeException("There are no fours in the array");
        }

        int resultLength = array.length - lastIndex - 1;
        int[] result = new int[resultLength];
        System.arraycopy(array, lastIndex + 1, result, 0, resultLength);

        return result;
    }
    public boolean arrayOnly(int[] array){
        if (array == null) {
            throw new RuntimeException("ArraysUtil not be empty");
        }
        boolean hasOne = false;
        boolean hasFour = false;

        for (int num : array) {
            if(num == 4)
                hasFour = true;
            else if (num == 1)
                hasOne = true;
            else {
                return false;
            }
        }
        return hasFour&&hasOne;
    }

}
