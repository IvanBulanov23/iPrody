import java.util.Arrays;

public class MyList {
    private static final double EXPAND_MULTIPLIER = 1.6;
    public Object[] arr;
    private int length = 0;

    public MyList(int size) {
        arr = new Object[size];
    }


    public void add(Object value) {
        if (arr.length <= length) {
            initializationArray((int) (arr.length * EXPAND_MULTIPLIER));
        }
        arr[length] = value;
        length++;
    }

    public Object get(int index) {
        if (index < 0 || index >= arr.length)
            throw new IndexOutOfBoundsException("Index " + index + " does not exist in array");
        return arr[index];
    }

    public int getLength() {
        return this.length;
    }
    public int getAllLength(){
        return this.arr.length;
    }

    public void initializationArray(int newSize) {
        Object[] newArr = new Object[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, length));
    }
}

