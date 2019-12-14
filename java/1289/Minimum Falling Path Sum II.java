class Solution {
    public int minFallingPathSum(int[][] arr) {
        int[][] arrRes = getMinAndSecond(arr[0]);
        int minSum = arrRes[0][0], minIndex = arrRes[0][1], secondSum = arrRes[1][0], secondIndex = arrRes[1][1];
        for (int i = 1; i < arr.length; i++) {
            int[][] curRes = getMinAndSecond(arr[i]);
            int curMin = curRes[0][0], curMinIndex = curRes[0][1], curSecond = curRes[1][0], curSecondIndex = curRes[1][1];
            if (curMinIndex != minIndex) {
                int newMinSum = minSum + curMin;
                minIndex = curMinIndex;
                int newSecondSum = minSum + curSecond;
                secondIndex = curSecondIndex;
                minSum = newMinSum;
                secondSum = newSecondSum;
            } else {
                if (minSum + curSecond < secondSum + curMin) {
                    int newMinSum = minSum + curSecond;
                    minIndex = curSecondIndex;
                    int newSecondSum = secondSum + curMin;
                    secondIndex = curMinIndex;
                    minSum = newMinSum;
                    secondSum = newSecondSum;
                } else {
                    int newMinSum = secondSum + curMin;
                    minIndex = curMinIndex;
                    int newSecondSum = minSum + curSecond;
                    secondIndex = curSecondIndex;
                    minSum = newMinSum;
                    secondSum = newSecondSum;
                }
            }
        }
        return minSum;
    }
    
    private int[][] getMinAndSecond(int[] A) {
        int curMin = 100;
        int curMinIndex = -1;
        int curSecond = 100;
        int curSecondIndex = -1;
        for (int j = 0; j < A.length; j++) {
            if (A[j] < curMin) {
                curMinIndex = j;
                curMin = A[j];
            }
        }
        for (int j = 0; j < A.length; j++) {
            if (j != curMinIndex && A[j] < curSecond) {
                curSecondIndex = j;
                curSecond = A[j];
            }
        }
        return new int[][] {{curMin, curMinIndex}, {curSecond, curSecondIndex}};
    }
    
}