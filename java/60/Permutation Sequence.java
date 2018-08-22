class Solution {
    public String getPermutation(int n, int k) {
        int[] r=new int[n];
        r[0]=1;
        for(int i=1;i<n;i++) r[i]=r[i-1]*(i+1);
        boolean[] flag=new boolean[n];
        String res="";
        int temp;
        int c1,c2;
        for(int i=1;i<n;i++)
        {
            temp=k;
            for(int j=2;j<=i;j++)
            {
                temp=k%r[n-j]==0?r[n-j]:k%r[n-j];
            }
            c1=0;
            c2=0;
            while(c1!=(temp-1)/r[n-i-1]+1)
            {
                c2++;
                while(flag[c2-1])
                {
                    c2++;
                }
                c1++;
            }
            res=res+c2;
            flag[c2-1]=true;
        }
        for(int i=0;i<flag.length;i++)
        {
            if(!flag[i]) res=res+(i+1);
        }
        return res;
    }
}