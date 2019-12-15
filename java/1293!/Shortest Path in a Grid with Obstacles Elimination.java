class Node {
    int i, j, pathLen, removedNum;
    public Node(int i, int j, int pathLen, int removedNum) {
        this.i = i;
        this.j = j;
        this.pathLen = pathLen;
        this.removedNum = removedNum;
    }
}
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][m * n];
        Queue<Node> q = new LinkedList<>();
        
        visited[0][0][0] = true;
        q.add(new Node(0, 0, 0, 0));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int i = node.i, j = node.j, pathLen = node.pathLen, removedNum = node.removedNum;
            if (i == m - 1 && j == n - 1) {
                return pathLen;
            }
            
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1], newRemovedNum = removedNum + grid[i][j];
                if (newI < 0 || newI >= m || newJ < 0 || newJ >= n || visited[newI][newJ][newRemovedNum] || newRemovedNum > k) continue;
                visited[newI][newJ][newRemovedNum] = true;
                q.add(new Node(newI, newJ, pathLen + 1, newRemovedNum));
            }
        }
        return -1;
    }
}