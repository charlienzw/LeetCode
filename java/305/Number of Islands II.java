//Time: O(klog(mn)) Space: O(mn)
class Solution {
    class UF
    {
        private int[] parent;
        private int[] rank;
        private int count = 0;
        public UF(int n)
        {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for(int i = 0; i <= n; i ++)
            {
                parent[i] = i;
                rank[i] = 1;
            }
            count = n;
        }
        public int find(int u)
        {
            while(parent[u] != u)
            {
                parent[u] = parent[parent[u]];
                u = parent[u];
            }
            return u;
        }
        public boolean union(int u, int v)
        {
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return false;
            if(rank[pu] < rank[pv])
            {
                parent[pv] = pu;
            }
            else if(rank[pu] > rank[pv])
            {
                parent[pu] = pv;
            }
            else
            {
                parent[pu] = pv;
                rank[pu]++;
            }
            count --;
            return true;
        }
        public int size()
        {
            return count;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UF uf = new UF(m * n);
        int[] map = new int[m * n];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i = 0; i < positions.length; i++)
        {
            for(int d = 0; d < 4; d++)
            {
                if(positions[i][0] + dir[d][0] >= 0 && positions[i][0] + dir[d][0] < m && positions[i][1] + dir[d][1] >= 0 && positions[i][1] + dir[d][1] < n && map[(positions[i][0] + dir[d][0]) * n + positions[i][1] + dir[d][1]] == 1)
                {
                    uf.union(positions[i][0] * n + positions[i][1], (positions[i][0] + dir[d][0]) * n + positions[i][1] + dir[d][1]);
                }
                    map[positions[i][0] * n + positions[i][1]] = 1;
            }
            res.add(uf.size() - (m * n - i - 1));
        }
        return res;
    }
}
