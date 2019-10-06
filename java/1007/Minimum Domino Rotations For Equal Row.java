class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int res = -1;
        int tryRes = getNumOfRotations(A, B, A[0]);
        if (tryRes != -1) {
            res = (res == -1) ? tryRes : Math.min(res, tryRes);
        }
        tryRes = getNumOfRotations(A, B, B[0]);
        if (tryRes != -1) {
            res = (res == -1) ? tryRes : Math.min(res, tryRes);
        }
        tryRes = getNumOfRotations(B, A, A[0]);
        if (tryRes != -1) {
            res = (res == -1) ? tryRes : Math.min(res, tryRes);
        }
        tryRes = getNumOfRotations(B, A, B[0]);
        if (tryRes != -1) {
            res = (res == -1) ? tryRes : Math.min(res, tryRes);
        }
        return res;
    }
    
    private int getNumOfRotations(int[] A, int[] B, int val) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == val) continue;
            else if (B[i] == val) res++;
            else return -1;
        }
        return res;
    }
}