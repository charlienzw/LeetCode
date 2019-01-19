class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long startnow = lower;
        for(int i = 0; i < nums.length; i++)
        {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] == startnow)
            {
                startnow++;
            }
            else
            {
                if(nums[i] == startnow + 1)
                {
                    res.add("" + startnow);
                    startnow = (long)nums[i] + 1;
                }
                else
                {
                    res.add(startnow + "->" + ((long)nums[i] - 1));
                    startnow = (long)nums[i] + 1;
                }
            }
        }
        if(startnow == upper)
        {
            res.add("" + startnow);
        }
        else if(startnow < upper)
        {
            res.add(startnow + "->" + upper);
        }
        return res;
    }
}