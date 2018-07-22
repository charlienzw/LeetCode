class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int[] A=new int[nums.length];
        fun(nums,A,0,result);
        return result;
    }
    
    public void fun(int[] nums,int[] A,int cur,List<List<Integer>> result)
    {
        if(cur==nums.length)
        {
            List<Integer> tmp=new ArrayList<Integer>();
            for(int i=0;i<cur;i++)
            {
                tmp.add(A[i]);
            }
            result.add(tmp);
        }
        else
        {
            for(int i=0;i<nums.length;i++)
            {
                int ok=1;
                for(int j=0;j<cur;j++)
                {
                    if(nums[i]==A[j])
                    {
                        ok=0;
                        break;
                    }
                }
                if(ok==1)
                {
                    A[cur]=nums[i];
                    fun(nums,A,cur+1,result);    
                }
            }
        }      
    }
}