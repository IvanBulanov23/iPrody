package Task1;

import java.util.*;

public class Tast1 {

    public static int countOccurance(List<String> wordList, String word) {
        int count = 0;
        for (String word1 : wordList) {
            if (word1.equals(word))
                count++;
        }
        return count;
    }

    public static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }


    public static List<Integer> findUnique(List<Integer> integerList) {
        List<Integer> list = new ArrayList<>();
        for (Integer value : integerList) {
            if (!list.contains(value))
                list.add(value);
        }
        return list;
    }

    public static void calcOccurance(List<String> stringList) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : stringList) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
