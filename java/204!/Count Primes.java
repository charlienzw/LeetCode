class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int res=0;
        boolean[] pri=new boolean[n-2];
        for(int i=2;i<n;i++)
        {
            pri[i-2]=true;
        }
        for(int i=2;i<n;i++)
        {
            if(pri[i-2]==true)
            {
                res++;
                for(int j=2;i*j<n;j++)
                    pri[i*j-2]=false;
            }
        }
        return res;
    }
}