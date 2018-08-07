class Solution {
    public int reverse(int x) {
        int res=0;
        int restemp=0;
        while(x!=0)
        {
            restemp=res;
            res=res*10+x%10;
            if((res-x%10)/10!=restemp) return 0;
            x=x/10;
        }
        return res;
    }
}