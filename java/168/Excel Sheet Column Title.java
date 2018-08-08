class Solution {
    public String convertToTitle(int n) {
        String res="";
        while(n>0)
        {
            n--;
            res=(char)((int)'A'+n%26)+res;
            n=n/26;
        }
        return res;
    }
}