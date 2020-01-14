class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int extraNum = 0;
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < connections.length; i++) {
            int p1 = find(parent, connections[i][0]);
            int p2 = find(parent, connections[i][1]);
            if (p1 == p2) extraNum++;
            else parent[p1] = p2;
        }
        
        int unConnectedNum = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) unConnectedNum++;
        }
        return extraNum >= (unConnectedNum - 1) ? (unConnectedNum - 1) : -1;
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}