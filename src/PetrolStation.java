import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PetrolStation {
    private volatile double fuel;
    private final Semaphore semaphore;
    private final Lock fuelLock = new ReentrantLock();

    public PetrolStation(double fuel) {
        this.fuel = fuel;
        this.semaphore = new Semaphore(3);
    }

    public void doTank(double requestedFuel) throws InterruptedException {
        semaphore.acquire();
        try {
            fuelLock.lock();
            try {
                if (requestedFuel > fuel) {
                    throw new IllegalStateException("Топлива нет, доступно " + fuel + " л, требуется " + requestedFuel + " л");
                }
                System.out.println("Зарезервировано за " + Thread.currentThread().getName() + ", " + requestedFuel + " л");
                fuel -= requestedFuel;
            } finally {
                fuelLock.unlock();
            }

            long sleep = (long) (1000 * (3 + Math.random() * 10));
            System.out.println(Thread.currentThread().getName() + " заправляется");
            Thread.sleep(sleep);
            System.out.println(Thread.currentThread().getName() + " заправился, остаток " + fuel + " л");

        } finally {
            semaphore.release();
        }
    }
}