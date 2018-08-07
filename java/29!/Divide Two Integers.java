class Solution {
    public int divide(int dividend, int divisor) {
        int sign=1;
        if(dividend<0&&divisor>0||dividend>0&&divisor<0) sign=-1;
        long ldividend=Math.abs((long)dividend);
        long ldivisor=Math.abs((long)divisor);
        long res=ldivide(ldividend,ldivisor);
        if(res>Integer.MAX_VALUE)
        {
            return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        else return (int)(sign*res);
    }
    public long ldivide(long ldividend,long ldivisor)
    {
        if(ldividend<ldivisor) return 0;
        long sum=ldivisor;
        long mul=1;
        while((sum+sum)<=ldividend)
        {
            sum=sum+sum;
            mul=mul+mul;
        }
        return mul+ldivide(ldividend-sum,ldivisor);
    }
}