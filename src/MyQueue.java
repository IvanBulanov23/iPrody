import java.util.NoSuchElementException;

public class MyQueue {
    private static class Node {
        private int value;
        private Node next = null;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return "value" + value;
        }
    }

    private Node head = null;
    private Node tail = null;
    public int lenght = 0;
    public int maxSize;


    public void inicialization(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Размер очереди должен быть положительным");
        }
        this.maxSize = maxSize;
        this.lenght = 0;
    }

    public void add(int value) {
        Node node = new Node(value);
        if (lenght == maxSize) {
            resize((int) (maxSize * 1.6));
        }
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;

        }
        lenght++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int removeValue = head.value;
        if (head == tail) {
            head = tail = null;
        } else {
            Node next = head.next;
            head.next = null;
            head = next;
        }
        return removeValue;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node value = head;
        while (value != null) {
            System.out.println(value.value);
            value = value.next;
        }
    }

    private void resize(int newCapacity) {
        maxSize = newCapacity;
    }

}
