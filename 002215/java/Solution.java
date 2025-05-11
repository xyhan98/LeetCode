import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDifference(new int[] { 1, 2, 3 }, new int[] { 2, 4, 6 }));
        System.out.println(s.findDifference(new int[] { 1, 2, 3, 3 }, new int[] { 1, 1, 2, 2 }));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(res1);
        res.add(res2);
        for (Integer num : set1) {
            if (!set2.contains(num)) {
                res1.add(num);
            }
        }
        for (Integer num : set2) {
            if (!set1.contains(num)) {
                res2.add(num);
            }
        }
        return res;
    }
}