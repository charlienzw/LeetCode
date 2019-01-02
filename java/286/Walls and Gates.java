// Set gate as the root of BFS
// Multi-end BFS

class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for(int ii = 0; ii < rooms.length; ii++)
        {
            for(int jj = 0; jj < rooms[0].length; jj++)
            {
                if(rooms[ii][jj] == 0)
                {
                    q.add(new int[]{ii, jj});
                }
            }
        }
        int[] temp;
        while(q.size() > 0)
        {
            int qsize = q.size();
            for(int j = 0; j < qsize; j++)
            {
                temp = q.poll();
                for(int i = 0; i < 4; i++)
                {
                    int nexti = temp[0] + dir[i][0];
                    int nextj = temp[1] + dir[i][1];
                    if(nexti >= 0 && nexti < rooms.length && nextj >= 0 && nextj < rooms[0].length && rooms[nexti][nextj] == Integer.MAX_VALUE)
                    {
                        rooms[nexti][nextj] = rooms[temp[0]][temp[1]] + 1;
                        q.add(new int[]{nexti, nextj});
                    }
                }                
            }
        }
    }
}