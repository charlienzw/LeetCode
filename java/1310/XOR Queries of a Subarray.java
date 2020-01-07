class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pre = new int[arr.length];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = arr[i] ^ (i == 0 ? 0 : pre[i - 1]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            res[i] = pre[right] ^ (left == 0 ? 0 : pre[left - 1]);
        }
        return res;
    }
}