import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("IceCreAm"));
        System.out.println(s.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
        set.add("A");
        set.add("E");
        set.add("I");
        set.add("O");
        set.add("U");
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (!set.contains(c)) {
                list.add(c);
            } else {
                stack.add(c);
                list.add(null);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                String c = stack.pop();
                list.set(i, c);
            }
        }
        return String.join("", list);
    }
}