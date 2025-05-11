public class Solution {
    public int coinChange(int[] coins, int amount) {
        long[] cache = new long[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            cache[i] = Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {
                if (coin > i) {
                    continue;
                } else {
                    cache[i] = Math.min(cache[i], cache[i - coin] + 1);
                }
            }
        }
        return (int) (cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount]);
    }
}