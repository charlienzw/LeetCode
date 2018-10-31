// Time: O(m + n)
// Space: O(n)

class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int res = 0;
        while(sb.length() < B.length())
        {
            sb.append(A);
            res++;
        }
        if(sb.toString().indexOf(B) != -1) return res;
        sb.append(A);
        if(sb.toString().indexOf(B) != -1) return res + 1;
        return -1;
    }
}