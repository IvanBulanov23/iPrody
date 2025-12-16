import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        randomInt();
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> integerPredicate = integer -> integer > 4;
        List<Integer> filterList = filterCollection(integerList, integerPredicate);
        System.out.println(filterList);

        List<String> stringList = List.of("Hello", ",", "world", "!");
        Predicate<String> stringPredicate = s -> s.length() > 4;
        String s = filterCollectionPredicat(stringList, stringPredicate);
        System.out.println(s);


        List<Integer> input = List.of(15, 23, 53, 3, 14, 55, 6, 9, 10, 10, 53);

        List<Integer> ascList = uniqueSorted(input, SortDirection.ASC);
        System.out.println(ascList);

        List<Integer> descList = uniqueSorted(input, SortDirection.DESC);
        System.out.println(descList);
        System.out.println(factorial(3));


        List<Boyscout> scouts = List.of(
                new Boyscout("Alex", 18, Team.red),
                new Boyscout("Sergey", 15, Team.blue),
                new Boyscout("Michael", 20, Team.red),
                new Boyscout("John", 17, Team.blue),
                new Boyscout("Bob", 16, Team.white)
        );

        Camp camp = new Camp(scouts);

        Map<Team, List<Boyscout>> groupedScouts = camp.split();

        System.out.println("{");
        for (Map.Entry<Team, List<Boyscout>> entry : groupedScouts.entrySet()) {
            System.out.println("\"" + entry.getKey().name() + "\", " + entry.getValue());
        }
        System.out.println("}");


    }


    public static void randomInt() {
        Random random = new Random();
        List<Integer> arrayList = IntStream.iterate(random.nextInt(1, 1001), i -> random.nextInt(1, 1001)).
                limit(100).
                boxed().
                toList();
        System.out.println(arrayList);
        List<Integer> result = arrayList.stream().
                sorted().
                limit(10).
                distinct().
                sorted(Comparator.reverseOrder()).
                toList();
        System.out.println(result);
    }

    public static <T> List<T> filterCollection(Collection<T> input, Predicate<T> predicate) {
        return input.stream().
                filter(predicate).
                collect(Collectors.toList());
    }

    public static String filterCollectionPredicat(Collection<String> strings, Predicate<String> predicate) {
        return strings.stream().
                filter(predicate).
                collect(Collectors.joining("|"));
    }

    public enum SortDirection {
        ASC, DESC
    }

    public static List<Integer> uniqueSorted(Collection<Integer> numbers, SortDirection direction) {
        Comparator<Integer> comparator = (direction == SortDirection.ASC)
                ? Comparator.naturalOrder()
                : Comparator.reverseOrder();

        return numbers.stream().distinct().sorted(comparator).collect(Collectors.toList());
    }

    public static long factorial(int n) {
        if (n < 0 || n > 12) throw new IllegalArgumentException();

        return Stream.iterate(1, i -> i <= n, i -> i + 1)
                .reduce(1, (a, b) -> a * b);
    }


}
