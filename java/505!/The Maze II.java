class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dis = new int[maze.length][maze[0].length];
        for(int[] d : dis) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dis[start[0]][start[1]] = 0;
        helper(maze, start, dis);
        return dis[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dis[destination[0]][destination[1]];
    }
    
    public void helper(int[][] maze, int[] start, int[][] dis) {
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{start[0], start[1], 0});
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            if(dis[temp[0]][temp[1]] < temp[2]) continue;
            for(int[] d : dir) {
                int x = temp[0] + d[0];
                int y = temp[1] + d[1];
                int cnt = 0;
                while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                    cnt++;
                }
                if(dis[temp[0]][temp[1]] + cnt < dis[x - d[0]][y - d[1]]) {
                    dis[x - d[0]][y - d[1]] = dis[temp[0]][temp[1]] + cnt;
                    pq.add(new int[]{x - d[0], y - d[1], dis[x - d[0]][y - d[1]]});
                }
            }
        }
    }
}