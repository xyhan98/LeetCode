import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));
        System.out.println(s.kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1));
        System.out.println(s.kidsWithCandies(new int[] { 12, 1, 12 }, 10));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int candy : candies) {
            if (candy > maxCandy) {
                maxCandy = candy;
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}