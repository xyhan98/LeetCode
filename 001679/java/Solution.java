import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxOperations(new int[] { 1, 2, 3, 4 }, 5));
        System.out.println(s.maxOperations(new int[] { 3, 1, 3, 4, 3 }, 6));
    }

    public int maxOperations(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        int i = 0;
        int j = list.size() - 1;
        int result = 0;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                result++;
                i++;
                j--;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}