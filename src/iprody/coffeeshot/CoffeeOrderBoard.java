package iprody.coffeeshot;

import java.util.*;

public class CoffeeOrderBoard {
    private List<Order> orders = new LinkedList<>();
    private int nextOrderNumber = 1;

    public void add(String customerName) {
        Order newOrder = new Order(customerName, nextOrderNumber);
        newOrder.setOrderNumber(nextOrderNumber);
        nextOrderNumber++;
        orders.add(newOrder);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            System.out.println("Заказов нет");
            return null;
        }
        Order deliverOrder = orders.get(0);
        orders.remove(0);
        System.out.println("Выдан заказ: " + deliverOrder);
        return deliverOrder;
    }

    public Order deliver(int orderNumber) {
        if (orders.isEmpty()) {
            System.out.println("Заказов нет");
            return null;
        }
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getOrderNumber() == orderNumber) {
                System.out.println("Выдан заказ: " + orderNumber + " " + order.getName() + " ");
                orders.remove(i);
                return order;
            }
        }
        System.out.println("Заказ " + orderNumber + " не найден");
        return null;
    }

    public void draw() {
        if (orders.isEmpty()) {
            System.out.println("Заказов нет");
            return;
        }
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " " + order.getName());
        }
    }
}
