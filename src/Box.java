import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void add(T fruit, int count) {
        for (int i = 0; i < count; i++) {
            fruits.add(fruit);
        }
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0.0f;
        }
        return fruits.size() * fruits.get(0).getWeight();
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001f;
    }

    public void transfer(Box<T> tBox) {
        if (this == tBox) {
            System.out.println("Нельзя пересыпать ящик в самого себя.");
            return;
        }

        if (this.fruits.isEmpty()) {
            System.out.println("Текущий ящик пуст, нечего пересыпать.");
            return;
        }
        tBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public void print() {
        if (fruits.isEmpty()) {
            System.out.println("Пусто");
        } else {
            for (T fruit : fruits) {
                System.out.println("- " + fruit);
            }
        }
    }

}
