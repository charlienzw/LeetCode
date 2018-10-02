class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        if(IsValid(s))
        {
            res.add(s);
            return res;
        }
        Queue<String> q=new LinkedList<>();
        q.add(s);
        String temps;
        boolean flag=false;
        int qsize=1;
        Set<String> visited=new HashSet<>();
        visited.add(s);
        while(q.size()>0)
        {
            qsize=q.size();
            for(int i=0;i<qsize;i++)
            {
                s=q.poll();
                for(int j=0;j<s.length();j++)
                {
                    if(s.charAt(j)=='('||s.charAt(j)==')')
                    {
                        temps=s.substring(0,j)+s.substring(j+1);
                        if(!visited.contains(temps)) 
                        {   
                            if(IsValid(temps))
                            {
                                flag=true;
                            }
                            q.add(temps);
                            visited.add(temps);
                        }
                    }
                }
            }
            if(flag)
            {
                break;
            }
        }
        while(q.size()>0)
        {
            temps=q.poll();
            if(IsValid(temps))
                res.add(temps);
        }
        return res;
    }
    public boolean IsValid(String s)
    {
        int cnt=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                cnt++;
            }
            else if(s.charAt(i)==')')
            {
                cnt--;
                if(cnt<0) return false;
            }
        }
        if(cnt!=0) return false;
        return true;
    }
}