class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Set<List<Integer>> initSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    initSet.add(list);
                }
            }
        }
        if (initSet.size() == 0) return 0;
        
        Queue<Set<List<Integer>>> q = new LinkedList<>();
        q.add(initSet);
        Set<Set<List<Integer>>> visited = new HashSet<>();
        int step = 0;
        while (q.size() > 0) {
            int qSize = q.size();
            step++;
            for (int k = 0; k < qSize; k++) {
                Set<List<Integer>> curSet = q.poll();
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        Set<List<Integer>> newSet = new HashSet<>(curSet);
                        flip(newSet, i, j, m, n);
                        if (newSet.size() == 0) return step;
                        if (!visited.contains(newSet)) {
                            visited.add(newSet);
                            q.add(newSet);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    private void flip(Set<List<Integer>> curSet, int i, int j, int m, int n) {
        flipOne(curSet, i, j);
        int[][] dirs = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
            flipOne(curSet, newI, newJ);
        }
    }
    
    private void flipOne(Set<List<Integer>> curSet, int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        if (curSet.contains(list)) {
            curSet.remove(list);
        } else {
            curSet.add(list);
        }
    }
}