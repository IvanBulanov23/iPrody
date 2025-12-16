public abstract class Fruit {
    private final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public String toString() {
        String className = this.getClass().getSimpleName();
        return className + " (вес: " + weight + "f)";
    }

}
