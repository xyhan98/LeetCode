public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
        System.out.println(s.compress(new char[] { 'a' }));
        System.out.println(s.compress(new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' }));
    }

    public int compress(char[] chars) {
        int i = 0;
        int j = 0;
        while (j < chars.length) {
            int k = 0;
            while (j + k < chars.length && chars[j] == chars[j + k]) {
                k++;
            }
            chars[i] = chars[j];
            i++;
            if (k > 1) {
                if (k < 10) {
                    chars[i] = Integer.toString(k).charAt(0);
                    i++;
                } else {
                    String str = Integer.toString(k);
                    for (int l = 0; l < str.length(); l++) {
                        chars[i + l] = str.charAt(l);
                    }
                    i += str.length();
                }
            }
            j += k;
        }
        return i;
    }
}