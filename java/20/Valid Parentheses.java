class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
            {
                st.push(s.charAt(i));
            }
            else
            {
                if(st.size()<=0) return false;
                if(!eq(st.pop(),s.charAt(i))) return false;
            }
        }
        if(st.size()>0) return false;
        return true;
    }
    public boolean eq(char left,char right)
    {
        if(left=='('&&right==')') return true;
        if(left=='['&&right==']') return true;
        if(left=='{'&&right=='}') return true;
        return false;
    }
}