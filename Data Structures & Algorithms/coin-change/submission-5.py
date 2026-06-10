class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        if not coins or not amount:
            return 0

        dp = [1e9] * (amount + 1)
        dp[0] = 0

        for i in range(1, amount+1):
            for coin in coins:
                if i - coin >= 0:
                    dp[i] = min(dp[i], 1 + dp[i - coin])

        return -1 if dp[amount] == 1e9 else dp[amount]



        