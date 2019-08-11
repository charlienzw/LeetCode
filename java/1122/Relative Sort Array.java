// O(n) time and space
// Count Sort
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cntArr1 = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            cntArr1[arr1[i]]++;
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (cntArr1[arr2[i]] > 0) {
                res[index++] = arr2[i];
                cntArr1[arr2[i]]--;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (cntArr1[i] > 0) {
                res[index++] = i;
                cntArr1[i]--;
            }
        }
        return res;
    }
}