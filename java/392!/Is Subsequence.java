class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> char2Indexes = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!char2Indexes.containsKey(t.charAt(i))) char2Indexes.put(t.charAt(i), new ArrayList<>());
            char2Indexes.get(t.charAt(i)).add(i);
        }
        
        // The lowest index of next character to build a subsequence
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!char2Indexes.containsKey(s.charAt(i))) return false;
            List<Integer> indexes = char2Indexes.get(s.charAt(i));
            int j = Collections.binarySearch(indexes, prev); 
            
            // If j < 0, prev does not in list, j is -insertionpoint - 1. Insertion point is the index of first element that is larger than key. We can get the insertion point.
            if (j < 0) {
                j = -j - 1;
            }
            
            // If insertion point is indexes.size(), all the indexes is less than prev. It will not be subsequence.
            if (j == indexes.size()) return false;
            
            // We use the index or insertion point of current key as the position that matches current key. Then next character will begin in the next position.
            prev = indexes.get(j) + 1;
        }
        
        return true;
    }
}