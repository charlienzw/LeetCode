class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> chstack = new ArrayDeque<>();
        Deque<Integer> numstack = new ArrayDeque<>();
        int numstart = -1;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                if(numstart == -1) numstart = i;
            }
            else
            {
                if(numstart != -1) 
                {
                    numstack.push(Integer.valueOf(s.substring(numstart, i)));
                    numstart = -1;
                }
                if(s.charAt(i) != ']')
                {
                    chstack.push(s.charAt(i));
                }
                else
                {
                    StringBuilder sbtemp = new StringBuilder();
                    while(chstack.peek() != '[')
                    {
                        sbtemp.append(chstack.pop());
                    }
                    chstack.pop();
                    int num = 1;
                    if(!numstack.isEmpty())
                    {
                        num = numstack.pop();
                    }
                    for(int k = 0; k < num; k++)
                    {
                        for(int j = sbtemp.length() - 1; j >= 0; j--)
                        {
                            chstack.push(sbtemp.charAt(j));
                        }                        
                    }
                }
            }
        }
        while(!chstack.isEmpty())
        {
            sb.append(chstack.pop());
        }
        return sb.reverse().toString();
    }
}