public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("the sky is blue"));
        System.out.println(s.reverseWords("  hello world  "));
        System.out.println(s.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i] + " ");
        }
        return sb.toString().trim();
    }
}