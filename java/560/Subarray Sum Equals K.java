class Solution {
    public int subarraySum(int[] nums, int k) {
        int res=0;
        int[] s=new int[nums.length];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        List<Integer> temp;
        for(int i=0;i<s.length;i++)
        {
            s[i]=i==0?nums[0]:s[i-1]+nums[i];
            if(s[i]==k) res++;
        }
        for(int i=0;i<s.length;i++)
        {
            if(!map.containsKey(s[i]))
            {
                temp=new ArrayList<>();
                temp.add(i);
                map.put(s[i],temp);
            }
            else
            {
                temp=map.get(s[i]);
                temp.add(i);
                map.put(s[i],temp);
            }
        }
        for(int i=0;i<s.length;i++)
        {
            if(map.containsKey(s[i]+k))
            {
                temp=map.get(s[i]+k);
                for(int j=0;j<temp.size();j++)
                {
                    if(temp.get(j)>i)
                    {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}