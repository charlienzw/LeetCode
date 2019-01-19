class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Set<Integer>> fre = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            fre.add(new HashSet<>());
        }
        for(int i = 0; i < nums.length; i++)
        {
            fre.get(map.get(nums[i]) - 1).add(nums[i]);
        }
        for(int i = fre.size() - 1; i >= 0; i--)
        {
            for(int x : fre.get(i))
            {
                res.add(x);
                if(res.size() == k) return res;
            }
        }
        return res;
    }
}