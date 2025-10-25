import java.lang.invoke.StringConcatException;

public class Employee {
    public Employee(String sfp, String email, String telephone, int age) {
        this.sfp = sfp;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
    }

    private String sfp;
    private String email;
    private String telephone;
    private int age;

    public String getSfp() {
        return sfp;
    }

    public void setSfp(String sfp) {
        this.sfp = sfp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
