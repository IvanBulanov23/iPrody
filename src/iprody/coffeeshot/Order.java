package iprody.coffeeshot;

public class Order {
    private final String name;
    private int orderNumber;

    public Order(String name, int orderNumber) {
        this.name = name;
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return orderNumber + " " + name;
    }
}
