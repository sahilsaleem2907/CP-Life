class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:

        counter = [0] * 26

        for task in tasks:
            counter[ord(task) - ord('A')] += 1
        
        counter.sort()
        maxf = counter[25]

        idle = (maxf - 1) * n

        for i in range(24, -1, -1):
            idle -= min(counter[i], maxf - 1)

        return max(0, idle) + len(tasks)

        
        