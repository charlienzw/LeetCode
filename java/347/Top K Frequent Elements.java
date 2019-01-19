class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for(int key : map.keySet())
        {
            pq.add(key);
            if(pq.size() > k) pq.poll();
        }
        while(pq.size() > 0)
        {
            res.add(pq.poll());
        }
        return res;
    }
}