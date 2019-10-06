class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        int res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - difference)) {
                dp[i] = dp[map.get(arr[i] - difference)] + 1;
            } else {
                dp[i] = 1;
            }
            map.put(arr[i], i);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}