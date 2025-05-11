import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeStars("leet**cod*e"));
        System.out.println(s.removeStars("erase*****"));
    }

    public String removeStars(String s) {
        List<String> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (c.equals("*")) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(c);
            }
        }
        return String.join("", stack);
    }
}