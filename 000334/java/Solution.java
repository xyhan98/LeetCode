import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
        // System.out.println(s.increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
        // System.out.println(s.increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));
        System.out.println(s.increasingTriplet(new int[] { 1, 5, 0, 4, 1, 3 }));
    }

    /*
     * FIXME: failed when int[] nums = new int[] { 1, 5, 0, 4, 1, 3 }
     */
    public boolean increasingTriplet_(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = -1;
            while (!stack.isEmpty() && nums[stack.get(stack.size() - 1)] < nums[i]) {
                int j = stack.remove(stack.size() - 1);
                indexes[j] = i;
            }
            stack.add(i);
        }
        // System.out.println(Arrays.toString(indexes));
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] != -1) {
                if (indexes[indexes[i]] != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}