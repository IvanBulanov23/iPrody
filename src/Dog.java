public class Dog extends Animal {
    private static final long id = 0;
    private static int nextid = 1;
    private String name;
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        super.id = nextid;
        nextid++;
        dogCount++;
    }
    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println("Расстояние не может быть отрицательным");
            return;
        }
        if (distance > 500)
            System.out.println(super.name + "собака, и не может пробежать " + distance + " м");
        else {
            System.out.println(super.name + " собака, и пробежал " + distance + " м");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 0) {
            System.out.println("Расстояние не может быть отрицательным");
            return;
        }
        System.out.println(super.name + " собака, и проплыла " + distance + " м");
    }
}
