class Solution:
    def mySqrt(self, x: int) -> int:
        i, j = 0, x
        while i <= j:
            mid = (i + j) // 2
            sqr = mid**2
            if sqr == x:
                return mid
            elif sqr < x:
                i = mid + 1
            else:
                j = mid - 1
        return j
