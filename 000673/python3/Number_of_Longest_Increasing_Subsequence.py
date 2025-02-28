from typing import List


class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        cache = [1 for _ in nums]
        count = [1 for _ in nums]
        for i in range(len(nums) - 2, -1, -1):
            length = 0
            c = count[i]
            for j in range(i + 1, len(nums)):
                if nums[j] > nums[i]:
                    if cache[j] > length:
                        length = cache[j]
                        c = count[j]
                    elif cache[j] == length:
                        c += count[j]
            cache[i] = length + 1
            count[i] = c
        maxLen = max(cache)
        result = 0
        for l, c in zip(cache, count):
            if l == maxLen:
                result += c
        return result
