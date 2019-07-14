class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2Map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            arr2Map.put(arr2[i], i);
        }
        Integer[] res = new Integer[arr1.length];
        for (int i = 0; i < res.length; i++) res[i] = new Integer(arr1[i]);
        Arrays.sort(res, (a, b) -> ((!arr2Map.containsKey(a) && !arr2Map.containsKey(b)) ? (a - b) : (arr2Map.getOrDefault(a, arr2.length) - arr2Map.getOrDefault(b, arr2.length))));
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = res[i];
        }
        return arr1;
    }
}