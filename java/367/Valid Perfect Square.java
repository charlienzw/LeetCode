class Solution {
    public boolean isPerfectSquare(int num) {
        int low=0,high=num;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if((long)num==((long)mid*(long)mid)) return true;
            else if((long)num<((long)mid*(long)mid)) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}