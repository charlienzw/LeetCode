class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> dp=new ArrayList<>();
        dp.add(0);
        int[] base=new int[n];
        for(int i=0;i<n;i++)
        {
            base[i]=(int)Math.pow(2,i);
        }
        for(int i=1;i<=n;i++)
        {
            int s=dp.size();
            dp.add(dp.get(dp.size()-1)+base[i-1]);
            for(int j=s-2;j>=0;j--)
            {
                dp.add(dp.get(j)+base[i-1]);
            }
        }
        return dp;
    }
}
