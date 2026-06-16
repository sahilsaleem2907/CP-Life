class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        index_lookup = defaultdict(list)

        for index, word in enumerate(wordDict):
            index_lookup[word[0]].append(index)

        # print(index_lookup)
        memo = {}

        def can_break(i):

            if i == len(s):
                return True

            if i in memo:
                return memo[i]

            for index in index_lookup[s[i]]:
                word = wordDict[index]
                if s[i: i + len(word)] == word and can_break(i + len(word)):
                    memo[i] = True
                    return True
            
            memo[i] = False

            return False

        return can_break(0)




        