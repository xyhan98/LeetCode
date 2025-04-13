import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][] {
                { 3, 2, 1 },
                { 1, 7, 6 },
                { 2, 7, 7 }
        };
        System.out.println(s.equalPairs(grid));
        grid = new int[][] {
                { 3, 1, 2, 2 },
                { 1, 4, 4, 5 },
                { 2, 4, 2, 2 },
                { 2, 4, 2, 2 }
        };
        System.out.println(s.equalPairs(grid));
    }

    public int equalPairs(int[][] grid) {
        List<String> rows = new ArrayList<>();
        List<String> cols = new ArrayList<>();
        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int cell : row) {
                sb.append(String.valueOf(cell) + " ");
            }
            rows.add(sb.toString().trim());
        }
        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                sb.append(String.valueOf(grid[i][j]) + " ");
            }
            cols.add(sb.toString().trim());
        }
        int res = 0;
        for (String row : rows) {
            for (String col : cols) {
                if (row.equals(col)) {
                    res++;
                }
            }
        }
        return res;
    }
}