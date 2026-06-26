class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)

        start, end = n - 1, 0
        available = gas[start] - cost[start]

        while start > end:

            if available < 0:
                start -= 1
                available += gas[start] - cost[start]

            else:
                available += gas[end] - cost[end]
                end += 1


        return start if available >= 0 else -1