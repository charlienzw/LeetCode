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
        if(intervals.length==0) return 0;
        Arrays.sort(intervals,new Comparator<Interval>(){public int compare(Interval a,Interval b){return a.start-b.start;}});
        PriorityQueue<Integer> q=new PriorityQueue<>();
        q.add(intervals[0].end);
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i].start>=q.peek())
            {
                q.poll();
            }
            q.add(intervals[i].end);
        }
        return q.size();
    }
}