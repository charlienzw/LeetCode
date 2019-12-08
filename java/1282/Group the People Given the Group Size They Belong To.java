class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> size2List = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (!size2List.containsKey(size)) {
                size2List.put(size, new ArrayList<>());
            }
            size2List.get(size).add(i);
            if (size2List.get(size).size() == size) {
                res.add(size2List.get(size));
                size2List.remove(size);
            }
        }
        return res;
    }
}