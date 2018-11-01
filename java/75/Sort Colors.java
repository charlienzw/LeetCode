class Solution {
    public void sortColors(int[] nums) {
        int wstart = -1, bstart = -1;
        int temp;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                if(bstart != -1 && i > bstart)
                {
                    temp = nums[i];
                    nums[i] = nums[bstart];
                    nums[bstart] = temp;
                    bstart++;
                    if(wstart != -1 && bstart - 1 > wstart)  
                    {
                        temp = nums[bstart - 1];
                        nums[bstart - 1] = nums[wstart];
                        nums[wstart] = temp;
                        wstart++; 
                    }
                }
                else if(wstart != -1 && i > wstart)
                {
                    temp = nums[i];
                    nums[i] = nums[wstart];
                    nums[wstart] = temp;
                    wstart++;                     
                }
            }
            else if(nums[i] == 1)
            {
                if(bstart != -1 && i > bstart)
                {
                    temp = nums[i];
                    nums[i] = nums[bstart];
                    nums[bstart] = temp;
                    bstart++; 
                    if(wstart == -1) wstart = bstart - 1;
                }
                else if(wstart == -1) wstart = i;
            }
            else
            {
                if(bstart == -1) bstart = i;
            }
        }
    }
}