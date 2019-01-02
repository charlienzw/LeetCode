class Solution {
    public int numDistinctIslands2(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int res = 0;
        List<Integer> shape;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    shape = new ArrayList<>();
                    dfs(grid, i, j, shape);
                    set.add(canonical(grid, shape));
                }
            }
        }
        return set.size();
    }
    
    public String canonical(int[][] grid, List<Integer> shape)
    {
        String resstr = "";
        int[] xs = new int[shape.size()];
        int[] ys = new int[shape.size()];
        int[] res= new int[shape.size()];
        int[][] dir = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        boolean isfirst = true;
        for(int i = 0; i < dir.length; i++)
        {
            int t = 0;
            int mx = Integer.MAX_VALUE, my = Integer.MAX_VALUE;
            for(int k = 0; k < shape.size(); k++)
            {
                int x, y;
                if(isfirst)
                {
                    x = shape.get(k) / grid[0].length;
                    y = shape.get(k) % grid[0].length;                    
                }
                else
                {
                    y = shape.get(k) / grid[0].length;
                    x = shape.get(k) % grid[0].length;                     
                }
                xs[t] = x * dir[i][0];
                mx = Math.min(mx, xs[t]);
                ys[t] = y * dir[i][1];
                my = Math.min(my, ys[t]);
                t++;
            }
            for(int k = 0; k < shape.size(); k++)
            {
                res[k] = (xs[k] - mx) * (grid.length + grid[0].length) + (ys[k] - my);
            }
            Arrays.sort(res);
            String candidate = Arrays.toString(res);
            if(resstr.compareTo(candidate) < 0) resstr = candidate;
            if(isfirst && i == dir.length - 1)
            {
                isfirst = false;
                i = -1;
            }
        }
        return resstr;
    }
    
    public void dfs(int[][] grid, int i, int j, List<Integer> shape)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) 
        {
            return;
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        shape.add(i * grid[0].length + j);
        grid[i][j] = 0;
        for(int d = 0; d < 4; d++)
        {
            dfs(grid, i + dir[d][0], j + dir[d][1], shape);
        }
    }
}