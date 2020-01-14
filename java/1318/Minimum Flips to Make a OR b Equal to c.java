class Solution {
    public int minFlips(int a, int b, int c) {
        int diff = (a | b) ^ c;
        int cur = 1;
        int res = 0;
        while (cur <= diff) {
            if ((diff & cur) != 0) {
                if (((a & cur) != 0) && ((b & cur) != 0)) {
                    res += 2;
                } else {
                    res++;
                }
            }
            cur = cur << 1;
        }
        return res;
    }
}