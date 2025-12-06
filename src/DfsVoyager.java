public class DfsVoyager implements Voyager {
    @Override
    public int lookupIslands(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    count++;
                    dfs(array, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] array, int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array[0].length || array[i][j] != 1) {
            return;
        }
        array[i][j] = 0;
        dfs(array, i - 1, j);
        dfs(array, i + 1, j);
        dfs(array, i, j - 1);
        dfs(array, i, j + 1);
    }
}
