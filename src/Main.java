import iprody.coffeeshot.CoffeeOrderBoard;
public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Ivan");
        coffeeOrderBoard.add("Nikolay");
        coffeeOrderBoard.add("Sergey");
        coffeeOrderBoard.add("Lola");
        coffeeOrderBoard.add("Zina");
        coffeeOrderBoard.add("Launda");

        CoffeeOrderBoard coffeeOrderBoard1 = new CoffeeOrderBoard();
        coffeeOrderBoard1.add("Ivan");
        coffeeOrderBoard1.add("Nikolay");
        coffeeOrderBoard1.add("Sergey");
        coffeeOrderBoard1.add("Lola");

        coffeeOrderBoard.draw();
        coffeeOrderBoard1.draw();

        coffeeOrderBoard.deliver();

        coffeeOrderBoard.deliver(4);

        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver(8);

    }
}
