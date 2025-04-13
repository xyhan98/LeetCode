import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.asteroidCollision(new int[] { 5, 10, -5 })));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[] { 8, -8 })));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[] { 10, 2, -5 })));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[] { -2, -1, 1, 2 })));
    }

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();
        for (int val : asteroids) {
            boolean flag = true;
            while (stack.size() > 0 && stack.get(stack.size() - 1) > 0 && val < 0) {
                Integer prev = stack.get(stack.size() - 1);
                if (Math.abs(prev) > Math.abs(val)) {
                    flag = false;
                    break;
                } else if (prev + val == 0) {
                    stack.remove(stack.size() - 1);
                    flag = false;
                    break;
                } else {
                    stack.remove(stack.size() - 1);
                    flag = true;
                }
            }
            if (flag) {
                stack.add(val);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return res;
    }
}