import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeList<Integer> intThreadSafeList = new ThreadSafeList<>();
        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                intThreadSafeList.add(i);
            }
            System.out.println("Thread 1 Go");
        });
        Thread addThread1 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                intThreadSafeList.add(i);
            }
            System.out.println("Thread 2 Go");
        });

        Thread removeThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                if (intThreadSafeList.size() > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    intThreadSafeList.remove(i);
                }
            }
            System.out.println("Thread 3 Go");
        });
        Thread getThread = new Thread(() -> {
            for (int i = 0; i < intThreadSafeList.size(); i++) {
                System.out.println(intThreadSafeList.get(i));
            }
            System.out.println("Thread 4 Go");
        });

        addThread.start();
        addThread1.start();
        removeThread.start();
        getThread.start();

        addThread.join();
        addThread1.join();
        removeThread.join();
        getThread.join();
        System.out.println(intThreadSafeList.size());



        PetrolStation station = new PetrolStation(100.0);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int j = 0; j < 10; j++) {
            final int carNumber1 = j;
            double requestedFuel1 = 5 + Math.random() * 20;

            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " подъехал к заправке");
                    station.doTank(requestedFuel1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Автомобиль " + carNumber1 + " прерван");
                } catch (IllegalStateException e) {
                    System.out.println("Автомобиль " + carNumber1 + ":" + e.getMessage());
                }
            });
        }
        executor.shutdown();
    }
}
