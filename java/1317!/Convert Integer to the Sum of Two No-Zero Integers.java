class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 0, base = 1, cur = n;
        while (cur > 0) {
            int d = cur % 10;
            cur /= 10;
            if ((d == 0 || d == 1) && cur > 0) {
                a += base * (1 + d);
                cur--;
            } else {
                a += base;
            }
            base *= 10;
        }
        return new int[] {a, n - a};
    }
}