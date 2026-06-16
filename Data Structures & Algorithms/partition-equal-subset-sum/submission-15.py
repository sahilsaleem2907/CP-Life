class Solution:
    def canPartition(self, nums: List[int]) -> bool:

        total = sum(nums)

        if total % 2 != 0:
            return False

        target = total // 2

        memo = {}

        def dfs(i, val):

            if val == target:
                return True

            if i >= len(nums) or val > target:
                return False

            if (i, val) in memo:
                return memo[(i, val)]

            for j in range(i + 1, len(nums)):
                if val + nums[j] <= target: 
                    if dfs(j, val + nums[j]):
                        memo[(i, val)] = True
                        return memo[(i, val)]

            memo[(i, val)] = False
            return False

        for i in range(len(nums)):
            if dfs(i, 0):
                return True

        return False
            
        