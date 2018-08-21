class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0) return 0;
        int res=0;
        Stack<Integer> st=new Stack<>();
        int start=-1;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(i);
            }
            else
            {
                if(st.size()==0)
                {
                    start=i;
                }
                else
                {
                    st.pop();
                    if(st.size()==0)
                    {
                        res=Math.max(res,i-start);   
                    }
                    else
                    {
                        res=Math.max(res,i-st.peek());   
                    }
                }
            }
        }
        return res;
    }
}