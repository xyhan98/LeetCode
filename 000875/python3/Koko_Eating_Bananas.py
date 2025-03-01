from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        i, j = 1, max(piles)
        while i <= j:
            mid = (i + j) // 2
            acc = 0
            for pile in piles:
                acc += pile // mid
                if pile % mid != 0:
                    acc += 1
            if acc <= h:
                j = mid - 1
            else:
                i = mid + 1
        return i
