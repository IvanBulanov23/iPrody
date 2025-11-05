import org.w3c.dom.ls.LSOutput;

public class Employee {
//    ФИО, должность, email, телефон, зарплата, возраст
    private String name;
    private String post;
    private String email;
    private String telephone;
    private Double salary;
    private int age;

    public Employee(String name, String post, String email, String telephone, Double salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void print(){
        System.out.println("name: " + name + ", post: " + post + ", email: " + email + ", telephone: " + telephone + ", salary: " + salary + ", age: " + age);
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", post: " + post +
                ", email: " + email +
                ", telephone: " + telephone +
                ", salary: " + salary +
                ", age: " + age;
    }

}
