class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int minDis = Integer.MAX_VALUE;
        int workerNum = workers.length, bikeNum = bikes.length;
        int[] dp = new int[1 << bikeNum]; // dp[i] is i state that represents which bikes are used
        // At least one worker, so dp[0] doesn't make sense.
        for (int s = 1; s < (1 << bikeNum); s++) {
            int curBikeNum = Integer.bitCount(s);
            if (curBikeNum > workerNum) {
                // If the number of used bikes is more than enough, then it doesn't make sense.
                continue;
            }
            dp[s] = Integer.MAX_VALUE;
            for (int i = 0; i < bikeNum; i++) {
                if ((s & (1 << i)) == 0) continue; // We only care the bikes that are used in this state
                int preS = s ^ (1 << i); // Consider the state without i
                // We assign to the workers one by one. So only consider the last worker
                dp[s] = Math.min(dp[s], dp[preS] + distance(workers[curBikeNum - 1], bikes[i]));
            }
            if (curBikeNum == workerNum)
                minDis = Math.min(minDis, dp[s]);
        }
        return minDis;
    }
    
    private int distance(int[] workerPos, int[] bikePos) {
        return Math.abs(workerPos[0] - bikePos[0]) + Math.abs(workerPos[1] - bikePos[1]);
    }
}