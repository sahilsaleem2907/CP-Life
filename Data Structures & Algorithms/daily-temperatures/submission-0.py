class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:

        answer = [0] * len(temperatures)
        stack = [] # [temp, index]

        for i, t in enumerate(temperatures):
            while stack and t > stack[-1][0]:
                stackT, stackI = stack.pop()
                answer[stackI] = i - stackI

            stack.append([t, i])

        return answer


        