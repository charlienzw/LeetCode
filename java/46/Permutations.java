class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0, res, new HashSet<>());
        return res;
    }
    
    public void helper(int[] nums, List<Integer> temp, int cur, List<List<Integer>> res, Set<Integer> set)
    {
        if(cur == nums.length)
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
                helper(nums, temp, cur + 1, res, set);
                set.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }   
    }
}