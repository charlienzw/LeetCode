class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    q.add(new int[]{i, j});
                }
            }
        }
        int[] temp;
        while(q.size() > 0)
        {
            temp = q.poll();
            for(int i = 0; i < 4; i++)
            {
                int newi = temp[0] + dir[i][0];
                int newj = temp[1] + dir[i][1];
                if(newi >= 0 && newi < matrix.length && newj >= 0 && newj < matrix[0].length && !visited[newi][newj] && matrix[newi][newj] != 0)
                {
                    matrix[newi][newj] = matrix[temp[0]][temp[1]] + 1;
                    visited[newi][newj] = true;
                    q.add(new int[]{newi, newj});
                }
            }
        }
        return matrix;
    }
}