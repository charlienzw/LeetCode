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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0)
        {
            intervals.add(newInterval);
        }
        else
        {
            int startnew=newInterval.start,endnew=newInterval.end,js=0;
            List<Integer> removeindex=new ArrayList<Integer>();
            int i=BinarySearch(intervals,newInterval.start);
            if(i>=0)
            {
                if(newInterval.start<=intervals.get(i).end)
                {
                    startnew=intervals.get(i).start;
                    js=i;
                }
                else
                {
                    js=i+1;
                }
            }
            for (int j=js;j<=intervals.size()-1;j++)
            {
                if(newInterval.end>=intervals.get(j).start)
                {
                    removeindex.add(j);
                    if(intervals.get(j).end>endnew)
                    {
                        endnew=intervals.get(j).end;
                    }
                }
                else
                {
                    break;
                }
            }
            for(int j=removeindex.size()-1;j>=0;j--)
            {
                int k=removeindex.get(j);
                intervals.remove(k);
            }
            Interval resultInterval=new Interval(startnew,endnew);
            intervals.add(js,resultInterval);
        }
        return intervals;
    }
    public int BinarySearch(List<Interval> intervals,int key)
    {
        int lo=0;
        int hi=intervals.size()-1;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(mid==intervals.size()-1)
            {
                if(key>=intervals.get(mid).start) return mid;
                else hi=mid-1;
            }
            else
            {
                if(key>=intervals.get(mid+1).start) lo=mid+1;
                else if(key<intervals.get(mid).start) hi=mid-1;
                else return mid;
            }
        }
        return -1;
    }
}