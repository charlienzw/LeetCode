class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> A=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(A.size()>=k+1) A.remove(nums[i-k-1]);
            if(!A.contains(nums[i]))
            {
                A.add(nums[i]);
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}