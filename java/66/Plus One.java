// Time: O(n)
// Space: O(1)
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) return digits;
        for(int i = digits.length - 1; i >= 0; i--)
        {
            if(digits[i] < 9)
            {
                digits[i] += 1;
                return digits;
            }
            else
            {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;     
    }
}