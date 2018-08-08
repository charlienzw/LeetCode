class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res="";
        if (strs.length==0) return res;
        int i=0;
        while(true)
        {
            int eq=1;
            for(int j=1;j<strs.length;j++)
            {
                if(i<strs[j].length()&&i<strs[0].length())
                {
                    if(strs[j].charAt(i)!=strs[0].charAt(i))
                    {
                        eq=0;
                        break;
                    }
                }
                else if(i<strs[j].length()&&i>=strs[0].length())
                {
                    eq=0;
                    break;
                }
                else if(i>=strs[j].length()&&i<strs[0].length())
                {
                    eq=0;
                    break;
                }
                else return res;
            }
            if(eq==1)
            {
                if(i>=strs[0].length()) return res;
                else
                {
                    res=res+strs[0].charAt(i);
                    i++;
                }
            }
            else break;
        }
        return res;
    }
}