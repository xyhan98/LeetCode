import java.util.HashMap;
import java.util.Map;

public class Solution {
    int[] nums;
    int target;
    Map<String, Integer> cache;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.cache = new HashMap<>();
        return dfs(0, 0);
    }

    private int dfs(int i, int sum) {
        if (i == this.nums.length) {
            return sum == this.target ? 1 : 0;
        }
        String key = String.format("%d, %d", i, sum);
        if (this.cache.containsKey(key)) {
            return this.cache.get(key);
        }
        int count = dfs(i + 1, sum + this.nums[i]) + dfs(i + 1, sum - this.nums[i]);
        this.cache.put(key, count);
        return count;
    }
}