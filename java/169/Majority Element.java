class Solution {
    public int majorityElement(int[] nums) {
        HashSet<Integer> HS=new HashSet<Integer>();
        int tmp;
        int cnt;
        for(int i=0;i<nums.length;i++)
        {
            HS.add(nums[i]);
        }
        Iterator iter=HS.iterator();
        int result=nums[0];
        int resultcnt=0;
        while(iter.hasNext())
        {
            tmp=(int)iter.next();
            cnt=0;
            for(int i=0;i<nums.length;i++)
            {
                if(tmp==nums[i])
                {
                    cnt=cnt+1;
                }
            }
            if(cnt>resultcnt)
            {
                result=tmp;
                resultcnt=cnt;
            }
        }
        return result;
    }
}