class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        for (int[] indice : indices) {
            if (rowSet.contains(indice[0])) {
                rowSet.remove(indice[0]);
            } else {
                rowSet.add(indice[0]);
            }
            if (columnSet.contains(indice[1])) {
                columnSet.remove(indice[1]);
            } else {
                columnSet.add(indice[1]);
            }
        }
        
        return rowSet.size() * (m - columnSet.size()) + columnSet.size() * (n - rowSet.size());
    }
}