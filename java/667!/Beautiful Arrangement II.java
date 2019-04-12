class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 0;
        for(int i = 1; i < n - k; i++) {
            res[index++] = i;
        }
        for(int i = 0; i <= k; i++) {
            res[index++] = i % 2 == 0 ? (n - k + i / 2) : (n - i / 2);
        }
        return res;
    }
}