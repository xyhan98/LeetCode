class Solution:
    def countSubstrings(self, s: str) -> int:
        result = 0
        for i in range(len(s)):
            result += 1
            for j in [i - 1, i]:
                k = i + 1
                while j >= 0 and k < len(s):
                    if s[j] == s[k]:
                        result += 1
                        j -= 1
                        k += 1
                    else:
                        break
        return result
