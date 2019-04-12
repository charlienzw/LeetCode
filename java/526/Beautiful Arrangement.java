class Solution {
    public int countArrangement(int N) {
        int[] count = new int[]{0};
        helper(N, count, 1, new HashSet<>());
        return count[0];
    }
    
    public void helper(int N, int[] count, int index, Set<Integer> set) {
        if(index == N + 1) {
            count[0]++;
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(!set.contains(i) && (i % index == 0 || index % i == 0)) {
                set.add(i);
                helper(N, count, index + 1, set);
                set.remove(i);
            }
        }
    }
}