/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0].end);
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i].start >= pq.peek())
            {
                pq.poll();
            }
            pq.add(intervals[i].end);
        }
        return pq.size();
    }
}