//Time: O(logn)
class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        double base = x;
        boolean isPositive = true;
        double p = 1; // MIN_VALUE corner case\
        
        if(n == Integer.MIN_VALUE) {
            n = Integer.MAX_VALUE;
            isPositive = false;
            p = x;
        }
        
        if(n < 0) {
            n = -n;
            isPositive = false;
        }
        
        while(n > 0) {
            if((n & 1) != 0) {
                res = res * base; // Only multiply the bit = 1 result
            }
            n = n >> 1;
            base = base * base;
        }
        
        return isPositive ? res : 1 / (res * p);
    }
}