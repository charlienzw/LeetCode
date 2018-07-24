class Solution {
    int tot;
    List<List<Integer>> vis;
    public int totalNQueens(int n) {
        List<List<String>> res=new ArrayList<List<String>>();
        vis=new ArrayList<List<Integer>>();
        vis.add(new ArrayList<Integer>());
        vis.add(new ArrayList<Integer>());
        vis.add(new ArrayList<Integer>());
        tot=0;
        List<Integer> tmp;
        for(int i=0;i<vis.size();i++)
        {
            tmp=vis.get(i);
            for(int j=0;j<2*n;j++)
            {
                tmp.add(0);
            }
            vis.set(i,tmp);
        }
        printqueens(n,0,res);
        return tot;    
    }
    
    public void printqueens(int n,int cur,List<List<String>> res)
    {
        if(cur==n)
        {
            tot++;
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(vis.get(0).get(i)==0&&vis.get(1).get(cur+i)==0&&vis.get(2).get(cur-i+n)==0)
            {
                List<Integer> tmp;
                tmp=vis.get(0);
                tmp.set(i,1);
                vis.set(0,tmp);
                tmp=vis.get(1);
                tmp.set(cur+i,1);
                vis.set(1,tmp);
                tmp=vis.get(2);
                tmp.set(cur-i+n,1);
                vis.set(2,tmp);
                printqueens(n,cur+1,res);
                tmp=vis.get(0);
                tmp.set(i,0);
                vis.set(0,tmp);
                tmp=vis.get(1);
                tmp.set(cur+i,0);
                vis.set(1,tmp);
                tmp=vis.get(2);
                tmp.set(cur-i+n,0);
                vis.set(2,tmp);
            }
        }
    }
    
}