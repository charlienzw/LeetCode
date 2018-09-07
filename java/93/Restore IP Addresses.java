class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        helper(res,"",new String(s),4);
        return res;
    }
    public void helper(List<String> res,String rs,String s,int n)
    {
        if(s.length()>3*n||s.length()<n) return;
        if(n==1)
        {
            if(s.length()==3&&Integer.valueOf(s)>255) return;
            if(s.length()>1&&s.charAt(0)=='0') return;
            res.add(rs+s);
            return;
        }
        for(int i=1;i<=Math.min(3,s.length());i++)
        {
            String tmp="";
            for(int j=0;j<i;j++)
                tmp=tmp+s.charAt(j);
            if(i==3&&Integer.valueOf(tmp)>255) continue;
            if(i>1&&tmp.charAt(0)=='0') continue;
            rs=rs+tmp+'.';
            s=s.substring(i);
            helper(res,rs,s,n-1);
            rs=rs.substring(0,rs.length()-i-1);
            s=tmp+s;
        }    
    }
}