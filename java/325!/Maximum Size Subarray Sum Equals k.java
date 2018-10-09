class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums.length==0) return 0;
        int res=0;
        int[] s=new int[nums.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            s[i]=i==0?nums[i]:s[i-1]+nums[i];
            if(s[i]==k) res=Math.max(res,i+1);
            map.put(s[i],i);
        }
        for(int i=0;i<s.length;i++)
        {
            if(map.containsKey(s[i]+k))
            {
                res=Math.max(res,map.get(s[i]+k)-i);
            }
        }
        return res;   
    }
}