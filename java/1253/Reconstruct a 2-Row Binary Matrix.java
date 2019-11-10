class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int upperSum = 0;
        int lowerSum = 0;
        int shareSum = 0;
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                shareSum++;
            }
        }
        
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 0) {
                upperList.add(0);
                lowerList.add(0);
            } else if (colsum[i] == 2) {
                upperList.add(1);
                lowerList.add(1);
            } else {
                if (upperSum + shareSum < upper) {
                    upperList.add(1);
                    lowerList.add(0);
                    upperSum++;
                } else if (lowerSum + shareSum < lower) {
                    upperList.add(0);
                    lowerList.add(1);
                    lowerSum++;
                } else {
                    return res;
                }                
            }
        }
        if (upperSum + shareSum != upper || lowerSum + shareSum != lower) return res;
        res.add(upperList);
        res.add(lowerList);
        return res;
    }
}