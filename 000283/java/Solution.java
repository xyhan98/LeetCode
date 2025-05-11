import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 0 };
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            int k = 0;
            while (j + k < nums.length && nums[j + k] == 0) {
                k++;
            }
            j += k;
            if (j < nums.length) {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}