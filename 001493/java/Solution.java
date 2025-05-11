import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubarray(new int[] { 1, 1, 0, 1 }));
        System.out.println(s.longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));
        System.out.println(s.longestSubarray(new int[] { 1, 1, 1 }));
    }

    public int longestSubarray(int[] nums) {
        int[] forward = new int[nums.length];
        forward[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 1) {
                forward[i + 1] = forward[i] + 1;
            } else {
                forward[i + 1] = 0;
            }
        }
        // System.out.println(Arrays.toString(forward));
        int[] backward = new int[nums.length];
        backward[nums.length - 1] = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == 1) {
                backward[i - 1] = backward[i] + 1;
            } else {
                backward[i - 1] = 0;
            }
        }
        // System.out.println(Arrays.toString(backward));
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = forward[i] + backward[i];
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }
}