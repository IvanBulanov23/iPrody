public class Main {
    public static void main(String[] args) {
    MyList myList = new MyList(2);
        System.out.println(myList.getLength());
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        System.out.println(myList.getLength());
        System.out.println(myList);

    }
}
