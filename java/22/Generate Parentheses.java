class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n==0)
        {
            result.add("");
        }
        else
        {
            for (int c=0;c<n;c++)
            {
                for (String left:generateParenthesis(c))
                    for (String right:generateParenthesis(n-c-1))
                        result.add("("+left+")"+right);
            }
        }
        return result;
    }
}