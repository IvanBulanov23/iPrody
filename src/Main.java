import Task1.Tast1;
import phonebook.TelephoneDirectory;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("Petr", "Anna", "Ivan", "Olya", "Anna", "Anna", "Olya",
                "Anna", "Ivan", "Ivan", "Oleg"));
        int occurance = Tast1.countOccurance(stringList, "Anna");
        System.out.println(occurance);

        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        List<Integer> integerList = Tast1.toList(arr);
        System.out.println(integerList);

        List<Integer> integersList1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 1, 2, 4, 3, 5, 7, 2, 1, 2));
        System.out.println(Tast1.findUnique(integersList1));

        Tast1.calcOccurance(stringList);

        
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Arshavin Andrey", "89174446871");
        telephoneDirectory.add("Zhirkov Yuri", "89613354768");
        telephoneDirectory.add("Arshavin Andrey", "89054336877");
        telephoneDirectory.add("Aldonin Evgeniy", "89113648425");
        System.out.println(telephoneDirectory.find("Zhirkov"));
        System.out.println(telephoneDirectory.findAll("Arshavin Andrey"));


    }
}
