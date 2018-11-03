class Solution {
    class point{
        int pi;
        int pj;
        point(int i, int j){
            pi = i;
            pj = j;
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return bfs(maze, new point(start[0], start[1]), new point(destination[0], destination[1]));
    }
    public boolean bfs(int[][] maze, point p, point des)
    {
        Queue<point> q = new LinkedList<>();
        q.add(p);
        int qsize = q.size();
        point temp;
        boolean visited[][] = new boolean[maze.length][maze[0].length];
        visited[p.pi][p.pj] = true;
        int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};        
        while(q.size() > 0)
        {
            qsize = q.size();
            for(int i = 0; i < qsize; i++)
            {
                temp = q.poll();
                for(int j = 0; j < 4; j++)
                {
                    int ti = temp.pi, tj = temp.pj;
                    while(ti >= 0 && ti < maze.length && tj >= 0 && tj < maze[0].length && maze[ti][tj] == 0)
                    {
                        ti += dir[j][0];
                        tj += dir[j][1];
                    }
                    ti -= dir[j][0];
                    tj -= dir[j][1];
                    if(visited[ti][tj]) continue;
                    if(ti == des.pi && tj == des.pj) return true;
                    visited[ti][tj] = true;
                    q.add(new point(ti, tj));
                }
            }
        }
        return false;
    }
}