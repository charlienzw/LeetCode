class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] intervals = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            intervals[i] = new int[] {Math.max(0, i - ranges[i]), Math.min(n, i + ranges[i])};
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int res = 0, start = 0, end = 0, i = 0;
        while (i <= n) {
            if (intervals[i][0] > start) {
                if (end <= start) return -1;
                start = end;
                res++;
                if (start >= n) return res;
            } else {
                end = Math.max(end, intervals[i][1]);
                i++;
            }
        }
        return res + 1;
    }
}