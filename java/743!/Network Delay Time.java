class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            if (!map.containsKey(times[i][0])) map.put(times[i][0], new ArrayList<>());
            map.get(times[i][0]).add(new int[] {times[i][1], times[i][2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {K, 0});
        
        Map<Integer, Integer> distance = new HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int node = temp[0], dis = temp[1];
            if (distance.containsKey(node)) continue;
            distance.put(node, dis);
            if (map.containsKey(node)) {
                for (int[] adjNode : map.get(node)) {
                    if (!distance.containsKey(adjNode[0])) {
                        pq.add(new int[] {adjNode[0], dis + adjNode[1]});
                    }
                }
            }
        }
        
        if (distance.size() != N) return -1;
        int res = 0;
        for (int dis : distance.values()) {
            res = Math.max(res, dis);
        }
        return res;
    }
}