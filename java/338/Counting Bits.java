class Solution {
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        res[0]=0;
        if(num==0) return res;
        int tmp=1;
        for(int i=1;i<=num;i++)
        {
            if(i>=tmp*2)
            {
                tmp=tmp*2;
            }
            res[i]=res[i-tmp]+1;
        }
        return res;
    }
}