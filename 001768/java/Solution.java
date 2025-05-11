public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mergeAlternately("abc", "pqr"));
        System.out.println(s.mergeAlternately("ab", "pqrs"));
    }

    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.substring(i, i + 1));
            sb.append(word2.substring(j, j + 1));
            i++;
            j++;
        }
        if (i == word1.length()) {
            sb.append(word2.substring(j));
        } else {
            sb.append(word1.substring(i));
        }
        return sb.toString();
    }
}