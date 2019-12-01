class Solution {
    public String tictactoe(int[][] moves) {
        List<int[]> aMarks = new ArrayList<>();
        List<int[]> bMarks = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                aMarks.add(moves[i]);
            } else {
                bMarks.add(moves[i]);
            }
        }
        if (check(aMarks)) {
            return "A";
        }
        if (check(bMarks)) {
            return "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
    
    private boolean check(List<int[]> marks) {
        int[] rowCount = new int[3];
        int[] columnCount = new int[3];
        int diag1Count = 0, diag2Count = 0;
        for (int[] mark : marks) {
            rowCount[mark[0]]++;
            columnCount[mark[1]]++;
            if (mark[0] == mark[1]) diag1Count++;
            if (mark[0] + mark[1] == 2) diag2Count++;
        }
        return rowCount[0] == 3 || rowCount[1] == 3 || rowCount[2] == 3 || columnCount[0] == 3 || columnCount[1] == 3 || columnCount[2] == 3 || diag1Count == 3 || diag2Count == 3;
    }
}