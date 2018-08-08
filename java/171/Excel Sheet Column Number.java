class Solution {
    public int titleToNumber(String s) {
        int res=0;
        for(int i=0;i<s.length();i++)
        {
            res=res*26+((int)s.charAt(i)-65+1);
        }
        return res;
    }
}