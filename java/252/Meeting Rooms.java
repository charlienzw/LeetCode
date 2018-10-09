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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length<=1) return true;
        Arrays.sort(intervals,new Comparator<Interval>() {
            public int compare(Interval n1,Interval n2)
            {   
                return n1.start-n2.start;
            }
        });
        for(int i=0;i<intervals.length-1;i++)
        {
            if(intervals[i].end>intervals[i+1].start)
            {
                return false;
            }
        }
        return true;
    }
}