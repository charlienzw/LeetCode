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
        List<Interval> result=new ArrayList<Interval>();
        if (intervals.size()>0)
        {
            QuickSort(intervals,0,intervals.size()-1);
            int startnow,endnow;
            startnow=intervals.get(0).start;
            int maxend=Integer.MIN_VALUE;
            int flag=0;
            for(int i=0;i<intervals.size()-1;i++)
            {
                flag=0;
                if(intervals.get(i).end>maxend)
                {
                    maxend=intervals.get(i).end;
                }
                if(intervals.get(i+1).start>maxend)
                {
                    endnow=maxend;
                    maxend=Integer.MIN_VALUE;
                    Interval I=new Interval(startnow,endnow);
                    result.add(I);
                    startnow=intervals.get(i+1).start;
                    flag=1;
                }
            }
            if (flag==1)
            {
                endnow=intervals.get(intervals.size()-1).end;
                Interval I=new Interval(startnow,endnow);
                result.add(I);
            }
            else
            {
                if(intervals.get(intervals.size()-1).end>maxend)
                {
                    maxend=intervals.get(intervals.size()-1).end;
                }
                endnow=maxend;
                Interval I=new Interval(startnow,endnow);
                result.add(I);
            }
        }
        return result;
    }
    
    public static int myPartition(List<Interval> intervals,int p,int r)
    {
        int x=intervals.get(r).start;
        int i=p-1;
        Interval tmp;
        for(int j=p;j<=r-1;j++)
        {
            if(intervals.get(j).start<x)
            {
                i=i+1;
                tmp=intervals.get(j);
                intervals.set(j,intervals.get(i));
                intervals.set(i,tmp);
            }
        }
        tmp=intervals.get(r);
        intervals.set(r,intervals.get(i+1));
        intervals.set(i+1,tmp);
        return i+1;
    }
    
    public static int myRandomizedPartition(List<Interval> intervals,int p,int r)
    {
        Random rand=new Random();
        int i=p+rand.nextInt(r-p+1);
        Interval tmp=intervals.get(i);
        intervals.set(i,intervals.get(r));
        intervals.set(r,tmp);
        return myPartition(intervals,p,r);
    }
    
    public static void QuickSort(List<Interval> intervals,int p,int r)
    {
        if(p<r)
        {
            int q=myRandomizedPartition(intervals,p,r);
            QuickSort(intervals,p,q-1);
            QuickSort(intervals,q+1,r);
        }
    }
    

    
}