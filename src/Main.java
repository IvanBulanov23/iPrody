// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Маркиз");
        Cat cat2 = new Cat("Толик");
        cat1.swim(21);
        cat1.run(12);
        cat2.swim(-1);
        cat2.run(330);
        System.out.println(cat1.getId());
        System.out.println(cat2.getId());

        Dog dog1 = new Dog("Альма");
        Dog dog2 = new Dog("Барон");
        Dog dog3 = new Dog("Босс");
        dog1.swim(10);
        dog1.run(30);
        dog2.swim(-30);
        dog2.run(-30);
        dog3.swim(30);
        dog3.run(450);
        System.out.println(dog1.getId());
        System.out.println(dog2.getId());
        System.out.println(dog3.getId());



    }
}