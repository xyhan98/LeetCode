from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        cache = [0 for _ in range(len(cost) + 1)]
        for i in range(2, len(cache)):
            cache[i] = min(cache[i - 1] + cost[i - 1], cache[i - 2] + cost[i - 2])
        return cache[-1]
