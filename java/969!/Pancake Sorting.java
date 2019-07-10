/*
    move the largest element A[i] to the end
        pancake flip i
        pancake flip N
*/

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        Integer[] aIndex = new Integer[A.length];
        for (int i = 0; i < aIndex.length; i++) {
            aIndex[i] = i + 1;
        }
        Arrays.sort(aIndex, (a, b) -> A[b - 1] - A[a - 1]);
        int N = A.length;
        for (int i : aIndex) {
            for (int j : res) {
                if (i <= j) {
                    i = j + 1 - i;
                }
            }
            res.add(i);
            res.add(N--);
        }
        return res;
    }
}