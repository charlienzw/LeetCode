// BFS
class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        if(isSquare(n)) return 1;
        int step = 1;
        q.add(n);
        set.add(n);
        int temp, tempnew;
        while(q.size() > 0)
        {
            int qsize = q.size();
            step++;
            for(int j = 0; j < qsize; j++)
            {
                temp = q.poll();
                for(int i = (int)Math.sqrt(temp); i >= 1; i--)
                {
                    tempnew = temp - i * i;
                    if(isSquare(tempnew))
                    {
                        return step;
                    }
                    if(!set.contains(tempnew) && tempnew > 0)
                    {
                        q.add(tempnew);
                        set.add(tempnew);
                    }
                }
            }
        }
        return -1;   
    }
    
    public boolean isSquare(int x)
    {
        return (double)(int)Math.sqrt(x) == Math.sqrt(x);
    }
}

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