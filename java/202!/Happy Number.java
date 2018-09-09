class Solution {
    public boolean isHappy(int n) {
        return helper((long) n);
    }
    public boolean helper(long n)
    {
        long slow=n,fast=n;
        while(true)
        {
            slow=squarenumber(slow);
            fast=squarenumber(squarenumber(fast));
            if(slow==fast) break;
        }
        return slow==1;        
    }
    public long squarenumber(long x)
    {
        long c=1;
        long s=0;
        while(true)
        {
            if(x/c==0) break;
            s=s+(x/c%10)*(x/c%10);
            c=c*10;
        }
        return s;
    }
}