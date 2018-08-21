class Solution {
    HashSet<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res=new HashSet<>();
        helper(nums,0,new ArrayList<>(),new boolean[nums.length]);
        List<List<Integer>> r=new ArrayList<>();
        Iterator<List<Integer>> iter=res.iterator();
        while(iter.hasNext())
        {
            r.add(iter.next());
        }
        return r;
    }
    public void helper(int[] nums,int cur,List<Integer> temp,boolean[] flag)
    {
        if(cur==nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!flag[i])
            {
                temp.add(nums[i]);
                flag[i]=true;
                helper(nums,cur+1,temp,flag);
                flag[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
}