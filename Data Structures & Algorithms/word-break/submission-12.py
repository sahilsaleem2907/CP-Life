class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        
        word_set = set(wordDict)
        t = 0

        for word in wordDict:
            t = max(t, len(word))

        memo = {}

        def can_break(i):

            if i == len(s):
                return True

            if i in memo:
                return memo[i]

            for j in range(i , min(len(s), i + t)):
                if s[i: j + 1] in word_set and can_break(j + 1):
                    memo[i] = True
                    return True
            
            memo[i] = False
            return False

        return can_break(0)




        