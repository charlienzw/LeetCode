class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> A=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!A.contains(nums[i]))
                A.add(nums[i]);
            else
            {
                return true;
            }
        }
        return false;
    }
}