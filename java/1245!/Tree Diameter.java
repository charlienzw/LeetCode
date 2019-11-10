class Solution {
    int res = 0;
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
        }
        dfs(map, 0);
        return res;
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int root) {
        if (!map.containsKey(root)) {
            return 0;
        }
        
        List<Integer> children = map.get(root);
        int firstDepth = 0, secondDepth = 0;
        for (Integer child : children) {
            int curDepth = dfs(map, child) + 1;
            if (firstDepth < curDepth) {
                secondDepth = firstDepth;
                firstDepth = curDepth;
            } else {
                secondDepth = Math.max(secondDepth, curDepth);
            }
        }
        res = Math.max(res, firstDepth + secondDepth);
        return firstDepth;
    }
}