class Solution {
    public String rearrangeString(String s, int k) {
        if(s.length()==0) return "";
        StringBuilder sb=new StringBuilder();
        int[] arr=new int[26];
        int[] app=new int[26];
        int index;
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']++;
        }
        while(sb.length()<s.length())
        {
            index=helper(arr,app,sb.length(),k);
            if(index==-1) return "";
            else
            {
                sb.append((char)('a'+index));
                arr[index]--;
                app[index]=sb.length()-1+k;
            }
        }
        return sb.toString();
    }
    public int helper(int[] arr,int[] app,int pos,int k)
    {
        int m=0;
        int mi=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>m&&pos>=app[i])
            {
                m=arr[i];
                mi=i;
            }
        }
        return mi;
    }
}