// DP
class Solution {
    public int numSquares(int n) {
        int[] r=new int[n];
        for(int i=0;i<n;i++)
        {
            if(judge(i+1))
            {
                r[i]=1;
            }
            else
            {
                r[i]=Integer.MAX_VALUE;
                for(int j=0;j<=(i-1)/2;j++)
                {
                    if(r[j]+r[i-j-1]<r[i])
                        r[i]=r[j]+r[i-j-1];
                }
            }
        }
        return r[n-1];
    }
    
    public boolean judge(int n)
    {
        if(Math.sqrt(n)==(int)Math.sqrt(n))
            return true;
        else return false;
    }
}

// Static DP
class Solution {
    public int numSquares(int n) {
        int[] r=new int[n];
        List<Integer> t=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(judge(i+1))
            {
                r[i]=1;
                t.add(i+1);
            }
            else
            {
                r[i]=Integer.MAX_VALUE;
                for(int j=0;j<t.size();j++)
                {
                    if(1+r[i-t.get(j)]<r[i])
                    {
                        r[i]=1+r[i-t.get(j)];
                    }
                }
            }
        }
        return r[n-1];
    }
    
    public boolean judge(int n)
    {
        if(Math.sqrt(n)==(int)Math.sqrt(n))
            return true;
        else return false;
    }
}