class Solution {
    public int shortestWay(String source, String target) {
        int m = source.length(), n = target.length();
        int[][] next = new int[m][26];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = m - 1; i >= 0; i--) {
            last[source.charAt(i) - 'a'] = i;
            for (int j = 0; j < 26; j++) {
                next[i][j] = last[j];
            }
        }
        
        int start = 0;
        int res = 1;
        int i = 0;
        while (i < n) {
            if (start >= m || next[start][target.charAt(i) - 'a'] == -1) {
                if (start == 0) return -1;
                else {
                    start = 0;
                    res++;
                }
            } else {
                start = next[start][target.charAt(i) - 'a'] + 1;
                i++;
            }
        }
        return res;
    }
}