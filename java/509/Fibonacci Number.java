class Solution {
    public int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        int dp1 = 0;
        int dp2 = 1;
        for(int i = 2; i <= N; i++) {
            int temp = dp2;
            dp2 = dp1 + dp2;
            dp1 = temp;
        }
        return dp2;
    }
}