class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] pre = new int[arr.length];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = i == 0 ? arr[i] : pre[i - 1] + arr[i];
        }
        
        int dist = Integer.MAX_VALUE, res = -1;
        for (int j = 0; j < arr[0]; j++) {
            int curDist = Math.abs(target - j * arr.length);
            if (curDist < dist) {
                dist = curDist;
                res = j;
            }
        }
        for (int i = 0; i < pre.length - 1; i++) {
            if (pre[i] > target) break;
            for (int j = arr[i]; j < arr[i + 1]; j++) {
                int curDist = Math.abs(target - (pre[i] + j * (arr.length - 1 - i)));
                if (curDist < dist) {
                    dist = curDist;
                    res = j;
                }
            }
        }
        int curDist = Math.abs(target - pre[pre.length - 1]);
        if (curDist < dist) {
            dist = curDist;
            res = arr[arr.length - 1];
        }
        return res;
    }
}