import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[] { 1, 2, 3, 4 })));
        System.out.println(Arrays.toString(s.productExceptSelf(new int[] { -1, 1, 0, -3, 3 })));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];
        int[] result = new int[nums.length];
        forward[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            forward[i + 1] = forward[i] * nums[i];
        }
        backward[backward.length - 1] = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            backward[i - 1] = backward[i] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = forward[i] * backward[i];
        }
        return result;
    }
}