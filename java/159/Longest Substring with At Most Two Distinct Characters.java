class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Character c1 = null, c2 = null;
        int c2first = -1;
        int res = 0;
        int tempres = 0;
        Character temp;
        for(int i = 0; i < s.length(); i++){
            if(c2 == null || c1 == null && c2 != s.charAt(i)){
                c1 = c2;
                c2 = s.charAt(i);
                c2first = i;
                tempres++;
            }
            else if(c2 != s.charAt(i) && c1 != s.charAt(i)){
                c1 = c2;
                c2 = s.charAt(i);
                res = Math.max(res, tempres);
                tempres = i - c2first + 1;
                c2first = i;
            }
            else{
                if(c2 != s.charAt(i)){
                    temp = c1;
                    c1 = c2;
                    c2 = temp;
                    c2first = i;
                }
                tempres++;
            }
        }
        res = Math.max(res, tempres);
        return res;
    }
}