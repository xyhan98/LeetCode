public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
        System.out.println(s.findMaxAverage(new int[] { 5 }, 1));
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum * 1.0 / k;
    }
}