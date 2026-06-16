class TrieNode:
    def __init__(self) -> None:
        self.children = {}
        self.is_word = False

class Trie:

    def __init__(self) -> None:
        self.root = TrieNode()

    def insert(self, word) -> None:
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]

        node.is_word = True

    def search(self, s, i, j):
        node = self.root

        for idx in range(i, j+1):
            if s[idx] not in node.children:
                return False
            node = node.children[s[idx]]

        return node.is_word


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        trie = Trie()
        t = 0 

        for word in wordDict:
            t = max(t, len(word))
            trie.insert(word)

        dp = [False] * (len(s) + 1)
        dp[len(s)] = True

        for i in range(len(s), -1, -1):
            for j in range(i, min(i + t, len(s))):

                if trie.search(s, i, j):
                    dp[i] = dp[j + 1]

                    if dp[i]:
                        break

        return dp[0]


        

        