class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(s.maxArea(new int[] { 1, 1 }));
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        }
        return max;
    }
}