class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldcolor = image[sr][sc];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        image[sr][sc] = newColor;
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        int[] temp;
        while(q.size() > 0)
        {
            temp = q.poll();
            for(int i = 0; i < 4; i++)
            {
                int newi = temp[0] + dir[i][0];
                int newj = temp[1] + dir[i][1];
                if(newi >= 0 && newi <= image.length - 1 && newj >= 0 && newj <= image[0].length - 1 && !visited[newi][newj] && image[newi][newj] == oldcolor)
                {
                    image[newi][newj] = newColor;
                    visited[newi][newj] = true;
                    q.add(new int[]{newi, newj});
                }
            }
        }
        return image;
    }
}