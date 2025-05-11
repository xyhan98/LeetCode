public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] cache = new boolean[m + 1][n + 1];
        for (int j = 0; j < n + 1; j++) {
            cache[m][j] = true;
        }
        for (int i = 0; i < m; i++) {
            cache[i][n] = false;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                String s1 = s.substring(i, i + 1);
                String t1 = t.substring(j, j + 1);
                if (s1.equals(t1)) {
                    cache[i][j] = cache[i + 1][j + 1];
                } else {
                    cache[i][j] = cache[i][j + 1];
                }
            }
        }
        return cache[0][0];
    }
}