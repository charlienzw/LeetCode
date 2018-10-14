class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        if(num.length()==0) return res;
        String temp=""+num.charAt(0);
        helper(res,num,(long)target,0,"",0,0);
        return res;
    }
    public void helper(List<String> res,String num,long target,int cur,String strnow,long valnow,long vallast)
    {
        if(cur>=num.length())
        {
            if(valnow==target)
                res.add(new String(strnow));
            return;
        }
        for(int i=cur;i<num.length();i++)
        {
            if(i!=cur&&num.charAt(cur)=='0') break;
            String part=num.substring(cur,i+1);
            long val=Long.valueOf(part);
            if(cur==0)
                helper(res,num,target,i+1,strnow+part,val,val);
            else
            {
                helper(res,num,target,i+1,strnow+'+'+part,valnow+val,val);
                helper(res,num,target,i+1,strnow+'-'+part,valnow-val,-val);
                helper(res,num,target,i+1,strnow+'*'+part,valnow-vallast+vallast*val,vallast*val);
            }
        }
    }
}