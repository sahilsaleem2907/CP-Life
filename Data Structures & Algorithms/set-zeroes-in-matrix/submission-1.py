class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:

        m = len(matrix)
        n = len(matrix[0])


        row_tracker = [0] * m
        col_tracker = [0] * n

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    row_tracker[i] = -1
                    col_tracker[j] = -1
                    continue

        for i in range(m):
            if row_tracker[i] == -1:
                for j in range(n):
                    matrix[i][j] = 0
                    
        for j in range(n):
            if col_tracker[j] == -1:
                for i in range(m):
                    matrix[i][j] = 0

        
        