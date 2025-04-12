public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(s.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(s.gcdOfStrings("LEET", "CODE"));
        System.out.println(s.gcdOfStrings("ABABABAB", "ABAB"));
        System.out.println(s.gcdOfStrings("ABCDEF", "ABC"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!str1.startsWith(str2) && !str2.startsWith(str1)) {
            return "";
        } else if (str1.equals(str2)) {
            return str1;
        }
        String temp = null;
        if (str1.length() > str2.length()) {
            temp = str1;
            str1 = str2;
            str2 = temp;
        }
        if (str2.length() % str1.length() == 0) {
            int repeat = str2.length() / str1.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < repeat; i++) {
                sb.append(str1);
            }
            if (sb.toString().equals(str2)) {
                return str1;
            } else {
                return "";
            }
        }
        int i = str1.length();
        while (i > 1) {
            if (str2.length() % i == 0 && str1.length() % i == 0) {
                break;
            }
            i--;
        }
        StringBuilder sb1 = new StringBuilder();
        for (int j = 0; j < str1.length() / i; j++) {
            sb1.append(str1.substring(0, i));
        }
        StringBuilder sb2 = new StringBuilder();
        for (int j = 0; j < str2.length() / i; j++) {
            sb2.append(str1.substring(0, i));
        }
        if (sb1.toString().equals(str1) && sb2.toString().equals(str2)) {
            return str1.substring(0, i);
        }
        return "";
    }
}