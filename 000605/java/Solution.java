public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
        System.out.println(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
        System.out.println(s.canPlaceFlowers(new int[] { 0, 0, 0 }, 2));
        System.out.println(s.canPlaceFlowers(new int[] { 0, 0, 0, 0, 0, 1, 0, 0 }, 0));
        System.out.println(s.canPlaceFlowers(new int[] { 1, 0, 1, 0, 1, 0, 1 }, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        } else if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n == 1;
        }
        int[] copy = new int[flowerbed.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = flowerbed[flowerbed.length - 1 - i];
        }
        return canPlace(flowerbed, n) || canPlace(copy, n);
    }

    private boolean canPlace(int[] flowerbed, int n) {
        int c = 0;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            c++;
        }
        int i = 1;
        while (i < flowerbed.length - 1) {
            int prev = flowerbed[i - 1];
            int curr = flowerbed[i];
            int next = flowerbed[i + 1];
            if (curr == 0 && prev == 0 && next == 0) {
                flowerbed[i] = 1;
                c++;
            }
            i++;
        }
        if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            c++;
        }
        return c >= n;
    }
}