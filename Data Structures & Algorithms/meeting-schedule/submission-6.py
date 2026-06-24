"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:

        if not intervals:
            return True

        meetings = defaultdict(int)

        for interval in intervals:
            meetings[interval.start] += 1
            meetings[interval.end] -= 1

        have = 0

        for time in sorted(meetings):
            have += meetings[time]

            if have > 1:
                return False


        return True






        
