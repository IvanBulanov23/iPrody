public class ValueCalculator {
    private static final int MIN_SIZE = 1_000_000;

    private int size;
    private double[] arr;

    public ValueCalculator(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("Размер массива должен быть не меньше " + MIN_SIZE);
        }
        if (size % 2 != 0) {
            throw new IllegalArgumentException("Размер массива должен быть четным");
        }
        this.size = size;
        this.arr = new double[size];
    }

    public void doCalc() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }
        int half = size / 2;
        double[] arr1 = new double[half];
        double[] arr2 = new double[half];
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] =(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        long end = System.currentTimeMillis();
        System.out.println("Время вычисления: " + (end - start) + " ms");

    }
}



//        arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)

