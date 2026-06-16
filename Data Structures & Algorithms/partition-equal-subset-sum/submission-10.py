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
                memo[(i, val)]

            for j in range(i + 1, len(nums)):
                if val + nums[j] <= target:
                    memo[(i, val)] = dfs(j, val + nums[j])
                    if memo[(i, val)]:
                        return True

            return False

        for i in range(len(nums)):
            if dfs(i, 0):
                return True

        return False
            
        