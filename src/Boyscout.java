public class Boyscout {
    private final String name;
    private final int age;
    private final Team team;
    public Boyscout(String name, int age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return name +
                " (" + age + ")";
    }
}

