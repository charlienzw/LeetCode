class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res=new ArrayList<>();
        if(k>n) return res;
        helper(n,k,0,new ArrayList<>(),1);
        return res;
    }
    public void helper(int n,int k,int cur,List<Integer> temp,int start)
    {
        if(cur==k)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=n;i++)
        {
            temp.add(i);
            helper(n,k,cur+1,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}