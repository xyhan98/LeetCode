import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
        System.out.println(s.uniqueOccurrences(new int[] { 1, 2 }));
        System.out.println(s.uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            Integer c = map.getOrDefault(num, 0);
            map.put(num, c + 1);
        }
        int size = map.entrySet().size();
        Set<Integer> set = new HashSet<>(map.values());
        return size == set.size();
    }
}