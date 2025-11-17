import java.util.Arrays;

public class MyList {
    private static final double EX = 1.6;
    public int[] arr;
    private int length = 0;
    public MyList (int size){
        arr = new int[size];
    };
    public void add (int value){
        if(arr.length <= length){
            EX_CAP((int) (arr.length*EX));
        }
        arr[length] = value;
        length++;
    }

    public int getLength() {
        return this.arr.length;
    }
    public void EX_CAP(int newSize){
        int[] newArr = new int[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, length));
    }
}

