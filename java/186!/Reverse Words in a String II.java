class Solution {
    public void reverseWords(char[] str) {
        if(str.length == 0) return;
        int pasti = 0;
        for(int i = 0; i < str.length; i++)
        {
            if(str[i] == ' ')
            {
                helper(str, pasti, i - 1);
                pasti = i + 1;
            }
        }
        helper(str, pasti, str.length - 1);
        helper(str, 0, str.length - 1);
    }
    
    public void helper(char[] str, int l, int r)
    {
        char temp;
        for(int i = l; i <= l + (r - l) / 2; i++)
        {
            temp = str[i];
            str[i] = str[l - i + r];
            str[l - i + r] = temp;
        }
    }
}