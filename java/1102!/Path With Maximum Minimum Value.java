class Solution {
    public int maximumMinimumPath(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        int low = 0, high = 1000000000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!check(A, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }
    
    private boolean check(int[][] A, int score) {
        if (A[0][0] < score) return false;
        boolean[][] visited = new boolean[A.length][A[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        visited[0][0] = true;
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (q.size() > 0) {
            int[] temp = q.poll();
            
            for (int[] dir : dirs) {
                int i = temp[0] + dir[0], j = temp[1] + dir[1];
                if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || visited[i][j] || A[i][j] < score) continue;
                if (i == A.length - 1 && j == A[0].length - 1) return true;
                visited[i][j] = true;
                q.add(new int[] { i, j });
            }
            
        }
        return false;
    }
}