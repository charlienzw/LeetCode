/*
State Diagram
*/

class Solution {
    public int checkRecord(int n) {
        int M = 1000000007;
        long a0l0 = 1, a0l1 = 1, a0l2 = 0, a1l0 = 1, a1l1 = 0, a1l2 = 0;
        for (int i = 1; i < n; i++) {
            long newA0l0 = (a0l0 + a0l1 + a0l2) % M;
            long newA0l1 = a0l0;
            long newA0l2 = a0l1;
            long newA1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M;
            long newA1l1 = a1l0;
            long newA1l2 = a1l1;
            a0l0 = newA0l0;
            a0l1 = newA0l1;
            a0l2 = newA0l2;
            a1l0 = newA1l0;
            a1l1 = newA1l1;
            a1l2 = newA1l2;
        }
        return (int)((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % M);
    }
}