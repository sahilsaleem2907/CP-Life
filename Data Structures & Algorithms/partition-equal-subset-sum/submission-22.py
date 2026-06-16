class Solution:
    def canPartition(self, nums: List[int]) -> bool:

        total = sum(nums)

        if total % 2 != 0:
            return False

        target = total // 2
        n = len(nums)

        dp = [False] * (target + 1)
        nextDp = [False] * (target + 1)

        dp[0] = True
        
        for i in range(n):
            for j in range(1, target+1):
                if nums[i] <= j:
                    nextDp[j] = dp[j] or dp[j - nums[i]]
                else:
                    nextDp[j] = dp[j]

            dp, nextDp = nextDp, dp

        return dp[target]

            
        