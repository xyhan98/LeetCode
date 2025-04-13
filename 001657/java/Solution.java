import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.closeStrings("abc", "bca"));
        System.out.println(s.closeStrings("a", "aa"));
        System.out.println(s.closeStrings("cabbba", "abbccc"));
        System.out.println(s.closeStrings("uau", "ssx"));
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            String s = word1.substring(i, i + 1);
            Integer count = map1.getOrDefault(s, 0);
            map1.put(s, count + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            String s = word2.substring(i, i + 1);
            Integer count = map2.getOrDefault(s, 0);
            map2.put(s, count + 1);
        }
        Set<String> key1 = map1.keySet();
        Set<String> key2 = map2.keySet();
        if (!key1.equals(key2)) {
            return false;
        }
        List<Integer> val1 = new ArrayList<>(map1.values());
        List<Integer> val2 = new ArrayList<>(map2.values());
        Collections.sort(val1);
        Collections.sort(val2);
        return val1.equals(val2);
    }
}