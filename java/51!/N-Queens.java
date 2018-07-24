class Solution {
    List<Integer> C;
    List<List<Integer>> vis;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<List<String>>();
        vis=new ArrayList<List<Integer>>();
        vis.add(new ArrayList<Integer>());
        vis.add(new ArrayList<Integer>());
        vis.add(new ArrayList<Integer>());
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
        C=new ArrayList<Integer>();
        printqueens(n,0,res);
        return res;
    }
    
    public void printqueens(int n,int cur,List<List<String>> res)
    {
        if(cur==n)
        {
            res.add(trans(C));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(vis.get(0).get(i)==0&&vis.get(1).get(cur+i)==0&&vis.get(2).get(cur-i+n)==0)
            {
                C.add(i);
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
                C.remove(C.size()-1);
            }
        }
    }
    
    public List<String> trans(List<Integer> C)
    {
        int n=C.size();
        List<String> S=new ArrayList<String>();
        String SS;
        for(int i=0;i<n;i++)
        {
            SS=new String();
            for(int j=0;j<n;j++)
            {
                if(C.get(i)==j)
                {
                    SS=SS.concat("Q");
                }
                else
                {
                    SS=SS.concat(".");
                }
            }
            S.add(SS);
        }
        return S;
    }
}