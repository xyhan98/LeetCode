import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxVowels("abciiidef", 3));
        System.out.println(s.maxVowels("aeiou", 2));
        System.out.println(s.maxVowels("leetcode", 3));
    }

    public int maxVowels(String s, int k) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
        int count = 0;
        for (int i = 0; i < k; i++) {
            String c = s.substring(i, i + 1);
            if (set.contains(c)) {
                count++;
            }
        }
        int maxCount = count;
        for (int i = k; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (set.contains(c)) {
                count++;
            }
            c = s.substring(i - k, i - k + 1);
            if (set.contains(c)) {
                count--;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}