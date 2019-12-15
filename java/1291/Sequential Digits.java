class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        List<Integer> table = getTable();
        for (Integer n : table) {
            if (n >= low && n <= high) {
                res.add(n);
            }
        }
        return res;
    }
    private List<Integer> getTable() {
        List<Integer> table = new ArrayList<>();
        for (int digitLen = 2; digitLen <= 9; digitLen++) {
            for (int i = 1; i <= 10 - digitLen; i++) {
                int cur = 0;
                for (int j = i; j <= i + digitLen - 1; j++) {
                    cur += j * (int)Math.pow(10, digitLen - j + i - 1);
                }
                table.add(cur);
            }            
        }
        return table;
    }
}