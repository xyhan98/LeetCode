import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[a]2[bc]"));
        System.out.println(s.decodeString("3[a2[c]]"));
        System.out.println(s.decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        int i = 0;
        while (i < s.length() && Character.isLetter(s.charAt(i))) {
            i++;
        }
        if (i == s.length()) {
            return s;
        }
        String prefix = s.substring(0, i);
        int j = 0;
        while (i + j < s.length() && Character.isDigit(s.charAt(i + j))) {
            j++;
        }
        int num = Integer.parseInt(s.substring(i, i + j));
        i += j;
        List<String> stack = new ArrayList<>();
        stack.add(s.substring(i, i + 1));
        int k = 1;
        while (i + k < s.length() && stack.size() > 0) {
            String c = s.substring(i + k, i + k + 1);
            if (c.equals("[")) {
                stack.add("[");
            } else if (c.equals("]")) {
                stack.remove(stack.size() - 1);
            }
            k++;
        }
        String inner = this.decodeString(s.substring(i + 1, i + k - 1));
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < num; l++) {
            sb.append(inner);
        }
        String suffix = this.decodeString(s.substring(i + k));
        return prefix + sb.toString() + suffix;
    }
}