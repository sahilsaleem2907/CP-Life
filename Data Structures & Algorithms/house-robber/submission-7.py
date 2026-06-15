class Solution:
    def rob(self, nums: List[int]) -> int:

        if not nums:
            return 0

        n = len(nums)

        if n == 1:
            return nums[0]

        rob1 = nums[0]
        rob2 = max(nums[0], nums[1])

        for i in range(2, n):
            temp = max(nums[i] + rob1, rob2)
            rob1 = rob2
            rob2 = temp

        return rob2

        