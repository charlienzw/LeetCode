class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        if(nums==null||nums.length==0) return res;
        int i=0;
        int cnt=1;
        int tmp;
        int x=nums[i];
        while(true)
        {
            x=nums[i];
            cnt=1;
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[j]==x)
                {
                    cnt++;
                    i=i+1;
                    tmp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=tmp;
                }
            }
            if(cnt>nums.length/3)
            {
                res.add(nums[i]);
            }
            i=i+1;
            if(i==nums.length) break;
        }
        return res;
    }
}