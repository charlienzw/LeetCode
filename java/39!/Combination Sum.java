class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0) return result;
        fun(candidates,target,result,new ArrayList<Integer>(),0);
        return result;
    }

    public void fun(int[] candidates,int target,List<List<Integer>> result,List<Integer> tmp,int cur)
    {
        if(target<0) return;
        if(target==0)
        {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=cur;i<candidates.length;i++)
        {
            tmp.add(candidates[i]);
            fun(candidates,target-candidates[i],result,tmp,i);
            tmp.remove(tmp.size()-1);
        }
    }
}