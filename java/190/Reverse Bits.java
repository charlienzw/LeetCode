public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long nn=(long)n;
        if(nn<0)
        {
            nn=Integer.MAX_VALUE+(nn-Integer.MIN_VALUE+1);
        }
        long x=(long)Math.pow(2,31);
        long res=0;
        while(nn!=0&&x!=0)
        {
            res=res+(nn%2)*x;
            System.out.println(nn%2);
            System.out.println(nn);
            x=x/2;
            nn=nn/2;
        }
        return (int)res;
    }
}