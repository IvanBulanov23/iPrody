import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 2, 1, 1},
                {1, 1, 2, 2, 1},
                {2, 2, 1, 2, 2},
                {2, 2, 2, 2, 1},
                {1, 1, 1, 2, 2}
        };
        System.out.println("Исходная карта:");
        printMap(map);
        Voyager dfsVoyager = new DfsVoyager();
        int dfsCount = dfsVoyager.lookupIslands(map);
        System.out.println("Количество островов: " + dfsCount);
        printMap(map);
    }

    private static void printMap(int[][] map) {
        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }
    }
}
