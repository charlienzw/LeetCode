// dp[i] = nums[i] % 2 != 0 ? dp[i - 1] + q.peek() - lastOdd : dp[i - 1]
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int dp = 0;
        Queue<Integer> q = new LinkedList<>();
        int lastOdd = -1;
        int lastCnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                q.add(i);
                if (q.size() == k) {
                    lastCnt = q.peek() - lastOdd;
                    dp += lastCnt;
                    lastOdd = q.poll();
                }
            } else {
                if (lastOdd != -1 && q.size() == k - 1) {
                    dp += lastCnt;
                }                
            }
        }
        return dp;
    }
}