from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        hashmap = dict()
        for i, num in enumerate(nums):
            if num in hashmap:
                if abs(i - hashmap[num]) <= k:
                    return True
            hashmap[num] = i
        return False
