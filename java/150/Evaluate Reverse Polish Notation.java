class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Deque<Integer> s = new ArrayDeque<>();
        int res = Integer.valueOf(tokens[0]);
        int num1, num2;
        for(int i = 0; i < tokens.length; i++)
        {
            if(tokens[i].equals("+"))
            {
                num2 = s.pop();
                num1 = s.pop();
                res = num1 + num2;
                s.push(res);
            }
            else if(tokens[i].equals("-"))
            {
                num2 = s.pop();
                num1 = s.pop();
                res = num1 - num2;
                s.push(res);
            }
            else if(tokens[i].equals("*"))
            {
                num2 = s.pop();
                num1 = s.pop();
                res = num1 * num2;
                s.push(res);
            }
            else if(tokens[i].equals("/"))
            {
                num2 = s.pop();
                num1 = s.pop();
                res = num1 / num2;
                s.push(res);
            }
            else
            {
                s.push(Integer.valueOf(tokens[i]));
            }
        }
        return res;
    }
}