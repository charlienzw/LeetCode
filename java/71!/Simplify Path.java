class Solution {
    public String simplifyPath(String path) {
        Stack<String> s=new Stack<>();
        String[] paths=path.split("/+");
        String res="";
        for(String str:paths)
        {
            if(str.equals(".."))
            {
                if(s.size()>0)
                {
                    s.pop();
                }
            }
            else if(!str.equals(".")&&!str.equals(""))
            {
                s.push(str);
            }
        }
        while(s.size()>0)
        {
            res="/"+s.pop()+res;
        }
        if(res.length()==0)
            res="/";
        return res;
    }
}