class Solution:
    def longestPalindrome(self, s: str) -> str:

        if not s:
            return ""

        res, resLen = [-1, -1], 0
        n = len(s)

        for i in range(n):
            l = r = i

            while l >= 0 and r < n and s[l] == s[r]:
                
                if r - l + 1 > resLen:
                    res = [l, r]
                    resLen = r - l + 1

                l -= 1
                r += 1

            l , r = i, i + 1

            while l >= 0 and r < n and s[l] == s[r]:
                
                if r - l + 1 > resLen:
                    res = [l, r]
                    resLen = r - l + 1

                l -= 1
                r += 1

        l, r = res
        return s[l: r+1]


        