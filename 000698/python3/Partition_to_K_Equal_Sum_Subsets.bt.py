from typing import List


class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        maxNum = nums[0]
        total = 0
        num_count_map = dict()
        for num in nums:
            total += num
            maxNum = max(maxNum, num)
            num_count_map[num] = num_count_map.get(num, 0) + 1
        if total % k != 0:
            return False
        target = total // k
        if maxNum > target:
            return False
        unique = list(num_count_map.keys())
        unique.sort(reverse=True)

        def dfs(i: int, acc: int, numSubset: int) -> bool:
            if numSubset == k:
                return True
            for j in range(i, len(unique)):
                num = unique[j]
                if num_count_map[num] == 0 or acc + num > target:
                    continue
                num_count_map[num] -= 1
                if acc + num == target:
                    if dfs(0, 0, numSubset + 1):
                        return True
                else:
                    if dfs(j, acc + num, numSubset):
                        return True
                num_count_map[num] += 1
            return False
        
        return dfs(0, 0, 0)
