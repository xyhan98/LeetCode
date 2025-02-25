class Solution:
    def minSteps(self, n: int) -> int:
        cache = dict()

        def dfs(count: int, clipboard: int):
            if count == n:
                return 0
            if count > n:
                return float('inf')
            if (count, clipboard) in cache:
                return cache[(count, clipboard)]
            cache[(count, clipboard)] = min(
                1 + dfs(count + clipboard, clipboard), # paste
                2 + dfs(count * 2, count) # copy and paste
            )
            return cache[(count, clipboard)]
        
        if n == 1:
            return 0
        return 1 + dfs(1, 1)
