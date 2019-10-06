class Solution {
    public int minCostToMoveChips(int[] chips) {
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                evenSum++;
            } else {
                oddSum++;
            }
        }
        return Math.min(evenSum, oddSum);
    }
}