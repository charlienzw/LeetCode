class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        int result = 0;
        int start = 0;
        for(int i = 0; i < prices.length - 1; i++)
        {
            if (prices[i + 1] - prices[i] < 0)
            {
                result = result + prices[i] - prices[start];
                start = i + 1;
            }
        }
        if (prices[prices.length - 1] - prices[prices.length - 2] >= 0)
            result=result+prices[prices.length-1] - prices[start];
        return result;
    }
}