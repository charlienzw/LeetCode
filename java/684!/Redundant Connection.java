class UF {
    int[] parent;
    int[] rank;
    public UF(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        if(rank[pa] < rank[pb]) {
            parent[pa] = pb;
            rank[pb]++;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1])) return e;
        }
        return new int[0];
    }
}