class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()==0) return 0;
        int start=-1,end=-1;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(end==-1&&s.charAt(i)!=' ')
                end=i;
            if(end!=-1&&s.charAt(i)==' ')
            {
                start=i+1;
                break;
            }
        }
        if(end==-1) return 0;
        if(end!=-1&&start==-1) start=0;
        return end-start+1;
    }
}