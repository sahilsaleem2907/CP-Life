class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        if not coins or not amount:
            return 0

        cache = {}

        def dfs(amount):

            if amount in cache:
                return cache[amount]

            if amount == 0:
                return 0

            res = 1e9

            for coin in coins:
                if amount - coin >= 0:
                    res = min(res, 1 + dfs(amount - coin))
                    
            cache[amount] = res

            return res

        minCoins = dfs(amount)
        return - 1 if minCoins == 1e9 else minCoins



        