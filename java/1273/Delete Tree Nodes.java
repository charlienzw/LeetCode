class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] res = new int[nodes];
        for (int i = nodes - 1; i >= 0; i--) {
            if (parent[i] == -1) continue;
            value[parent[i]] += value[i];
            res[parent[i]] += (value[i] != 0 ? (res[i] + 1) : 0);
        }
        return value[0] != 0 ? (res[0] + 1) : 0;
    }
}