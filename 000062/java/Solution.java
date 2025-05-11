public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            cache[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            cache[m - 1][j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                cache[i][j] = cache[i + 1][j] + cache[i][j + 1];
            }
        }
        return cache[0][0];
    }
}