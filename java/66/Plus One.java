class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]=digits[digits.length-1]+1;
        int [] result=null;
        for (int i=digits.length-1;i>0;i--)
        {
            if (digits[i]>=10)
            {
                digits[i]=digits[i]-10;
                digits[i-1]=digits[i-1]+1;
            }
        }
        if (digits[0]>=10)
        {
            digits[0]=digits[0]-10;
            result=new int[digits.length+1];
            result[0]=1;
            for (int j=0;j<digits.length;j++)
            {
                result[j+1]=digits[j];
            }
        }
        else
        {
            result=digits;
        }
        return result;
    }
}