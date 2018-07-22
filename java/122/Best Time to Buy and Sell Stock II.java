class Solution {
    public int maxProfit(int[] prices) {
        int result=0;
        int dis=0;
        int start=0;
        for(int i=0;i<prices.length-1;i++)
        {
            dis=prices[i+1]-prices[i];
            if (dis<0)
            {
                result=result+prices[i]-prices[start];
                start=i+1;
            }
            else if(i==prices.length-2)
            {
                result=result+prices[prices.length-1]-prices[start];
            }
        }
        return result;
    }
}