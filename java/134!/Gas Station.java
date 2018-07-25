class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0||cost.length==0||gas.length!=cost.length)
            return -1;
        int n=gas.length;
        int gasnow=0;
        int cur=-1;
        for(int i=0;i<n;i++)
        {
            if(gas[i%n]>=cost[i%n])
            {
                cur=i;
                break;
            }
        }
        if(cur==-1)
            return -1;
        int start=cur;
        int res=cur;
        gasnow=gasnow+gas[cur%n]-cost[cur%n];
        while(true)
        {
            cur=cur+1;
            if(cur==res+n) return res;
            if(gasnow+gas[cur%n]<cost[cur%n])
            {
                res=cur+1;
                while(true)
                {
                    if(gas[res%n]>=cost[res%n]) break;
                    res++;
                }
                if(res>start+n) break;
                cur=res-1;
                gasnow=0;
            }
            else
            {
                gasnow=gasnow+gas[cur%n]-cost[cur%n];
            }
        }
        return -1;
    }
}