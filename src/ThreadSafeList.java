import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<E> {
    private final List<E> threadSafeList = new ArrayList<>();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void add(E element) {
        readWriteLock.writeLock().lock();
        try {
            threadSafeList.add(element);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void remove(int index) {
        readWriteLock.writeLock().lock();
        try {
            threadSafeList.remove(index);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public E get(int index) {
        readWriteLock.readLock().lock();
        try {
            if (index < 0 || index >= threadSafeList.size()) {
                throw new IndexOutOfBoundsException();
            }
            return threadSafeList.get(index);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int size() {
        readWriteLock.readLock().lock();
        try {
            return threadSafeList.size();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
