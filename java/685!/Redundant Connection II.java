/*
3 case
    case 1: 2 parents no circle
    case 2: 2 parents with circle
    case 3: 1 parent with circle
*/
class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
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
        if (pa == pb) {
            return false;
        }
        parent[pb] = pa;
        return true;
    }
    
}

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        int[] parent = new int[N + 1];
        int[] twoParentEdge = null;
        for (int[] edge : edges) {
            if (parent[edge[1]] != 0) {
                twoParentEdge = edge;
            } else {
                parent[edge[1]] = edge[0];
            }
        }
        
        UnionFind uf = new UnionFind(N + 1);
        
        // Case 3
        if (twoParentEdge == null) {
            for (int[] edge : edges) {
                if (!uf.union(edge[0], edge[1])) return edge;
            }
        }
        
        // Case 1 & 2
        int[] otherTwoParentEdge = null;
        for (int[] edge : edges) {
            if (edge[1] != twoParentEdge[1]) {
                uf.union(edge[0], edge[1]);
            } else {
                if (edge[0] != twoParentEdge[0]) otherTwoParentEdge = edge;
            }
        }

        if (!uf.union(otherTwoParentEdge[0], otherTwoParentEdge[1])) return otherTwoParentEdge;
        else return twoParentEdge;
    }
}