// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Employee ivanov = new Employee("Иванов Иван Иванович", "fitter", "ivanov@mal.ru", "89184441379", 130d, 56);
        Employee obezhev = new Employee("Объезжев Алексей Николаевич", "engineer", "obezhev@mal.ru", "89181245512", 150d, 45);
        Employee zobnin = new Employee("Зобнин Дмитрий Анатольевич", "buyer", "zobnin@mal.ru", "89181442876", 140d, 32);
        Employee titov = new Employee("Титов Матвей Владимирович", "director", "titov@mal.ru", "89181243667", 210d, 41);
        Employee zamkovaya = new Employee("Замковая Мария Дмитриевна", "secretary", "zamkovaya@mal.ru", "89184841394", 120d, 25);

        Employee[] employees = new Employee[]{ivanov, obezhev, zobnin, titov, zamkovaya};
        for (Employee emp : employees) {
            if (emp.getAge() > 40) { // или if (emp.age > 40)
                emp.print();
            }
        }

    }
}