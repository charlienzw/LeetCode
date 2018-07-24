class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if (k==0) return res;
        List<Integer> exist=new ArrayList<Integer>();
        for(int i=1;i<=9;i++)
        {
            exist.add(0);
        }
        fun(res,new ArrayList<Integer>(),exist,k,n,1);
        return res;
    }
    
    public void fun(List<List<Integer>> res,List<Integer> tmp,List<Integer> exist,int k,int n,int cur)
    {
        if(n<0) return;
        if(n==0)
        {
            if(tmp.size()==k)
                res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int num=cur;num<=9;num++)
        {
            if(exist.get(num-1)==0)
            {
                tmp.add(num);
                exist.set(num-1,1);
                fun(res,tmp,exist,k,n-num,num);
                tmp.remove(tmp.size()-1);
                exist.set(num-1,0);
            }
        }
    }
}