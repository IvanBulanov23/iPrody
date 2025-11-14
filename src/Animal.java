public abstract class Animal {
    protected String name;
    protected int id;
    private static int animalCount = 0;
    protected static int maxRun, maxSwim;

    public Animal(String name) {
        this.name = name;
        this.id = id++;
        animalCount++;
    }

    public int getId() {
        return id;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getAnimalCount() {
        return animalCount;
    }
}
