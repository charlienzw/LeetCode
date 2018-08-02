class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int first=1;
        int second=2;
        int third=0;
        for(int i=2;i<=n-1;i++)
        {
            third=first+second;
            first=second;
            second=third;
        }
        return third;
    }
}