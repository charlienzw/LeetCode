class Solution {
    public int findSpecialInteger(int[] arr) {
        int cur = -1;
        int cnt = 0;
        int limit = (int)(0.25 * arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (cur != arr[i]) {
                cur = arr[i];
                cnt = 1;
            } else {
                cnt++;
            }
            if (cnt > limit) {
                return cur;
            }
        }
        return -1;
    }
}