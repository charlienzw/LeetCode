//Time: O(logn)
class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        double b = x; //base
        int sign = 1; //1: positive 0: negative
        double p = 1; // MIN_VALUE corner case
        if(n == Integer.MIN_VALUE)
        {
            n = Integer.MAX_VALUE;
            sign = 0;
            p = x;
        }
        if(n < 0)
        {
            n = -n;
            sign = 0;
        }
        
        while(n > 0)
        {
            if((n & 1) != 0)
            {
                res = res * b;
            }
            n = n >> 1;
            b = b * b;
        }
        
        if(sign == 1)
            return res;
        else
        {
            return 1 / (res * p);
        }
    }
}