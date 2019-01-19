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
        if (intervals.size() > 0)
        {
            intervals.sort((x, y) -> x.start - y.start);
            int startnow, endnow;
            startnow = intervals.get(0).start;
            int maxend = Integer.MIN_VALUE;
            int flag = 0;
            for(int i = 0; i < intervals.size() - 1; i++)
            {
                flag = 0;
                if(intervals.get(i).end > maxend)
                {
                    maxend = intervals.get(i).end;
                }
                if(intervals.get(i + 1).start > maxend)
                {
                    endnow = maxend;
                    maxend = Integer.MIN_VALUE;
                    Interval I = new Interval(startnow, endnow);
                    res.add(I);
                    startnow = intervals.get(i + 1).start;
                    flag = 1;
                }
            }
            if (flag==1)
            {
                endnow = intervals.get(intervals.size()-1).end;
                Interval I = new Interval(startnow, endnow);
                res.add(I);
            }
            else
            {
                if(intervals.get(intervals.size()-1).end > maxend)
                {
                    maxend = intervals.get(intervals.size() - 1).end;
                }
                endnow = maxend;
                Interval I = new Interval(startnow, endnow);
                res.add(I);
            }
        }
        return res;
    }
}