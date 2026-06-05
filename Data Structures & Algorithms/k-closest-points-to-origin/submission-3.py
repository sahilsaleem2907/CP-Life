class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:

        max_heap = []

        for x,y in points:
            d = x ** 2 + y ** 2

            heapq.heappush(max_heap, [-d, x, y])
            if len(max_heap) > k:
                heapq.heappop(max_heap)

            heapq.heapify(max_heap)
            



        res = []

        for d,x,y in max_heap:
            res.append([x,y])

        return res
        