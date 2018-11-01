// Time: O(m*n*k)
// Space: O(m*n)
class Solution {
    class point{
        int px;
        int py;
        point(int i, int j)
        {
            px = i;
            py = j;
        }
    }
    int[][] costsum;
    int[][] visitcnt;
    public int shortestDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
        {
            return -1;
        }
        int buildcnt = 0;
        costsum = new int[grid.length][grid[0].length];
        visitcnt = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    bfs(grid, i, j);
                    buildcnt ++;
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && costsum[i][j] != 0 && visitcnt[i][j] == buildcnt) {
                    res = Math.min(res, costsum[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public void bfs(int[][] grid, int starti, int startj)
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<point> q = new LinkedList<>();
        q.add(new point(starti, startj));
        int qsize = q.size();
        point temppoint;
        int layer = 1;
        visited[starti][startj] = true;
        while(q.size() > 0)
        {
            qsize = q.size();
            for(int i = 0; i < qsize; i++)
            {
                temppoint = q.poll();
                if(temppoint.py < grid[0].length - 1 && !visited[temppoint.px][temppoint.py + 1])
                {
                    visited[temppoint.px][temppoint.py + 1] = true;
                    if(grid[temppoint.px][temppoint.py + 1] == 0)
                    {
                        q.add(new point(temppoint.px, temppoint.py + 1));
                        visitcnt[temppoint.px][temppoint.py + 1] += 1;
                        costsum[temppoint.px][temppoint.py + 1] += layer;
                    }
                }
                if(temppoint.px > 0 && !visited[temppoint.px - 1][temppoint.py])
                {
                    visited[temppoint.px - 1][temppoint.py] = true;
                    if(grid[temppoint.px - 1][temppoint.py] == 0)
                    {
                        q.add(new point(temppoint.px - 1, temppoint.py));
                        visitcnt[temppoint.px - 1][temppoint.py] += 1;
                        costsum[temppoint.px - 1][temppoint.py] += layer;
                    }
                }
                if(temppoint.px < grid.length - 1 && !visited[temppoint.px + 1][temppoint.py])
                {
                    visited[temppoint.px + 1][temppoint.py] = true;
                    if(grid[temppoint.px + 1][temppoint.py] == 0)
                    {
                        q.add(new point(temppoint.px + 1, temppoint.py));
                        visitcnt[temppoint.px + 1][temppoint.py] += 1;
                        costsum[temppoint.px + 1][temppoint.py] += layer;
                    }
                }
                if(temppoint.py > 0 && !visited[temppoint.px][temppoint.py - 1])
                {
                    visited[temppoint.px][temppoint.py - 1] = true;
                    if(grid[temppoint.px][temppoint.py - 1] == 0)
                    {
                        q.add(new point(temppoint.px, temppoint.py - 1));
                        visitcnt[temppoint.px][temppoint.py - 1] += 1;
                        costsum[temppoint.px][temppoint.py - 1] += layer;
                    }
                }
            }
            layer++;
        }
    }
}