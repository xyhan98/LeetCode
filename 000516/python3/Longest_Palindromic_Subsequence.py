class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        cache = [[0 for _ in s] for _ in s]
        for i in range(1, len(s) + 1):
            for j in range(len(s) - i + 1):
                sub = s[j:j + i]
                # print(sub)
                if len(sub) == 1:
                    cache[j][j] = 1
                else:
                    if s[j] == s[j + i - 1]:
                        cache[j][j + i - 1] = 2 + cache[j + 1][j + i - 2]
                    else:
                        cache[j][j + i - 1] = max(cache[j][j + i - 2], cache[j + 1][j + i - 1])
        return cache[0][-1]

# https://www.youtube.com/watch?v=_nCsPn7_OgI
s = Solution()
print(s.longestPalindromeSubseq("agbdba"))