public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] cache = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    cache[i][j] = cache[i + 1][j + 1] + 1;
                } else {
                    cache[i][j] = Math.max(cache[i + 1][j], cache[i][j + 1]);
                }
            }
        }
        return cache[0][0];
    }
}