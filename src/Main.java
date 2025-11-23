import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList myList = new MyList(3);
        System.out.println(myList.getAllLength());
        System.out.println(myList.getLength());
        myList.add(1);
        myList.add("string");
        myList.add(3);
        myList.add(4);
        myList.add(5);
        System.out.println(myList.getLength());
        System.out.println(myList.getAllLength());
        System.out.println(myList);
        System.out.println(myList.get(3));
        MyList myList1 = new MyList(2);
        myList1.add("S");
        System.out.println(myList1);
        System.out.println(myList1.get(4));

        MyQueue myQueue = new MyQueue();
        myQueue.inicialization(2);
        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);
        myQueue.add(12);
        myQueue.print();
        System.out.println();

        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());

        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();
        try {
            int result = arrayValueCalculator.doCalc(array);
            System.out.println(result);
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println(e.getMessage());
        }

        ArrayValueCalculator arrayValueCalculator1 = new ArrayValueCalculator();
        try {
            int result1 = arrayValueCalculator1.doCalc(array1);
            System.out.println(result1);
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println(e.getMessage());
        }

        ArrayValueCalculator arrayValueCalculator2 = new ArrayValueCalculator();
        try {
            int result2 = arrayValueCalculator2.doCalc(array2);
            System.out.println(result2);
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
