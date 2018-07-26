class Solution {
    public int maxProfit(int[] prices) {
        int[] res1=maxProfit1(prices,0,prices.length-1);
        if(res1[2]<=0) return 0;
        int res_out=res1[2];
        int[] res2=maxProfit1(prices,0,res1[0]-1);
        int[] res3=maxProfit1(prices,res1[1]+1,prices.length-1);
        if(res2[2]<res3[2])
        {
            res_out=res_out+res3[2];
        }
        else
        {
            res_out=res_out+res2[2];
        }
        
        int[] middle=new int[res1[1]-res1[0]-1];
        for(int i=0;i<middle.length;i++)
        {
            middle[i]=prices[res1[1]-1-i];
        }
        int[] resmiddle=maxProfit1(middle,0,middle.length-1);
        int res_in=res1[2]+resmiddle[2];
        if(res_out<res_in) return res_in;
        else return res_out;
    }
    public int[] maxProfit1(int[] prices,int low,int high) {
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        int tempi=0;
        int[] minmaxi=new int[3];
        for (int i=low;i<=high;i++)
        {
            if(prices[i]<minprice)
            {
                minprice=prices[i];
                tempi=i;
            }
            else if(prices[i]-minprice>maxprofit)
            {
                maxprofit=prices[i]-minprice;
                minmaxi[0]=tempi;
                minmaxi[1]=i;
            }
        }
        minmaxi[2]=maxprofit;
        return minmaxi;
    }
}