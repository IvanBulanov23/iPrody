package phonebook;

public class Record {
    public String name;
    public String telephone;

    public Record(String name, String telephone) {
        if (name == null || name.isEmpty() || telephone == null || telephone.isEmpty()) {
            throw new IllegalArgumentException("Имя и телефон не могут быть null или пустыми");
        }
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" + "name= " + name + '\'' +
                ", telephone= " + telephone + "}";
    }
}
