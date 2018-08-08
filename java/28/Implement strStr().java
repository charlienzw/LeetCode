class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int[] pi=helper(needle);
        int q=0;
        for(int i=0;i<haystack.length();i++)
        {
            while(q>0&&needle.charAt(q)!=haystack.charAt(i))
                q=pi[q-1];
            if(needle.charAt(q)==haystack.charAt(i))
                q++;
            if(q==needle.length())
            {
                return i-needle.length()+1;
            }
        }
        return -1;
    }
    public int[] helper(String needle)
    {
        int[] ret=new int[needle.length()];
        ret[0]=0;
        int k=0;
        for(int q=1;q<needle.length();q++)
        {
            while(k>0&&needle.charAt(k)!=needle.charAt(q))
            {
                k=ret[k-1];
            }
            if(needle.charAt(k)==needle.charAt(q))
                k=k+1;
            ret[q]=k;
        }
        return ret;
    }
}