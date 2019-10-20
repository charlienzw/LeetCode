class Solution {
    public boolean checkRecord(String s) {
        int aCnt = 0, lCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                aCnt++;
                lCnt = 0;
                if (aCnt > 1) return false;
            } else if (s.charAt(i) == 'L') {
                lCnt++;
                if (lCnt > 2) return false;
            } else {
                lCnt = 0;
            }
        }
        return true;
    }
}