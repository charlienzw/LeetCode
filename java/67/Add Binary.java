class Solution {
    public String addBinary(String a, String b) {
        int s,add=0;
        String c="";
        int i=a.length()-1;
        int j=b.length()-1;
        while(true)
        {
            if(i<0&&j<0)
            {
                s=add;
            }
            else if(i<0&&j>=0) s=c2i(b.charAt(j))+add;
            else if(i>=0&&j<0) s=c2i(a.charAt(i))+add;
            else s=c2i(a.charAt(i))+c2i(b.charAt(j))+add;
            if(s>1)
            {
                add=s/2;
                s=s%2;
            }
            else
            {
                add=0;
            }
            if(i<0&&j<0&&s==0&&add==0) break;
            c=s+c;
            i--;
            j--;
        }
        return c;
    }
    public int c2i(char c)
    {
        return c-'0';
    }
}