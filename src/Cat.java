public class Cat extends Animal {
    private static final long id = 0;
    private static int nextid = 1;
    private String name;
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        super.id = nextid;
        nextid++;
        catCount++;
    }
    public static int getCatCount() {
        return catCount;
    }
    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println("Расстояние не может быть отрицательным");
            return;
        }
        if (distance > 200)
            System.out.println(super.name + " и он не может пробежать " + distance + " м");
        else {
            System.out.println(super.name + " кот и он пробежал " + distance + " м");
        }

    }

    @Override
    public void swim(int distance) {
        System.out.println(super.name + " кот, а коты не умеют плавать");
    }

}
