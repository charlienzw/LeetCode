class Solution {
    public int mySqrt(int x) {
        int low=0;
        int high=x;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if((long)x>=((long)mid*(long)mid)&&(long)x<((long)(mid+1)*(long)(mid+1))) return mid;
            else if((long)x<((long)mid*(long)mid)) high=mid-1;
            else low=mid+1;
        }
        return 0;
    }
}