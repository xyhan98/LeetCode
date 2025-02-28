from typing import List


class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        total = 0
        maxNum = nums[0]
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
        cache = [list() for _ in range(target + 1)]
        cache[0].append(dict())
        for num, count in num_count_map.items():
            for i in range(1, target + 1):
                if num > i:
                    continue
                for d in cache[i - num]:
                    copy = dict(d)
                    copy[num] = copy.get(num, 0) + 1
                    if copy[num] <= count:
                        cache[i].append(copy)
        # print(cache[-1])

        def dfs(i: int) -> bool:
            s = set(num_count_map.values())
            if len(s) == 1 and 0 in s:
                return True
            if any(map(lambda x: x < 0, s)):
                return False
            for j in range(i, len(cache[-1])):
                d: dict = cache[-1][j]
                for num, c in d.items():
                    num_count_map[num] -= c
                if dfs(j):
                    return True
                for num, c in d.items():
                    num_count_map[num] += c
            return False
        
        return dfs(0)
