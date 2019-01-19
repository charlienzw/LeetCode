class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), res, new HashSet<>());
        return res;
    }
    
    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> res, Set<Integer> set)
    {
        if(temp.size() == nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(!set.contains(nums[i]))
            {
                temp.add(nums[i]);
                set.add(nums[i]);
                helper(nums, temp, res, set);
                set.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }   
    }
}