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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0) return res;        
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        int i = 0;
        int start = intervals.get(0).start;
        while(i < intervals.size() - 1) {
            if(intervals.get(i).end < intervals.get(i + 1).start) {
                res.add(new Interval(start, intervals.get(i).end));
                start = intervals.get(i + 1).start;
            }
            i++;
        }
        res.add(new Interval(start, intervals.get(intervals.size() - 1).end));
        return res;
    }
}