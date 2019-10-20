class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> queenSet = new HashSet<>();
        for (int[] queen : queens) {
            List<Integer> list = new ArrayList<>();
            list.add(queen[0]);
            list.add(queen[1]);
            queenSet.add(list);
        }
        int[][] dirs = new int[][] {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        for (int[] dir : dirs) {
            int x = king[0] + dir[0], y = king[1] + dir[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                if (queenSet.contains(list)) {
                    res.add(list);
                    break;
                }
                x += dir[0];
                y += dir[1];
            }
        }
        return res;
    }
}