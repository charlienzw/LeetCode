class Solution {
    int[] ans, cnts;
    List<Set<Integer>> graph;
    int N;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        graph = new ArrayList<>();
        ans = new int[N];
        cnts = new int[N];
        this.N = N;
        Arrays.fill(cnts, 1);
        
        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        helper(0, -1);
        helper2(0, -1);
        return ans;
    }
    
    private void helper(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                helper(child, node);
                cnts[node] += cnts[child];
                ans[node] += ans[child] + cnts[child];
            }
        }
    }
    
    private void helper2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                ans[child] = ans[node] - cnts[child] + N - cnts[child];
                helper2(child, node);
            }
        }
    }
}