public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while(n != 0)
        {
            sum++;
            n = n & (n - 1); // Every time set the least significant '1' to '0'
        }
        return sum;
    }
}