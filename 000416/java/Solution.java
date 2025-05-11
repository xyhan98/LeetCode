import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canPartition_(int[] nums) {
        int total = Arrays.stream(nums).reduce(0, Integer::sum);
        if (total % 2 == 1) {
            return false;
        }
        int half = total / 2;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            Set<Integer> set2 = new HashSet<>();
            for (Integer sum : set) {
                set2.add(sum + num);
            }
            set.addAll(set2);
            set.add(num);
            if (set.contains(half)) {
                return true;
            }
        }
        return false;
    }

    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).reduce(0, Integer::sum);
        if (total % 2 == 1) {
            return false;
        }
        int m = nums.length + 1;
        int n = total / 2 + 1;
        boolean[][] cache = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            cache[i][0] = true;
        }
        for (int i = 1; i < m; i++) {
            int num = nums[i - 1];
            for (int j = 1; j < n; j++) {
                if (num > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = cache[i - 1][j] || cache[i - 1][j - num];
                }
            }
        }
        return cache[m - 1][n - 1];
    }
}