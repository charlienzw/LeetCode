/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int n = wordlist.length;
        int len = wordlist[0].length();
        
        // Calculate the match number between each other words
        int[][] matchMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int curMatches = 0;
                for (int k = 0; k < len; k++) {
                    if (wordlist[i].charAt(k) == wordlist[j].charAt(k)) {
                        curMatches++;
                    }
                }
                matchMap[i][j] = matchMap[j][i] = curMatches;
            }
        }
        
        // Reduce the scope as each try
        List<Integer> possible = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            possible.add(i);
        }
        Set<Integer> visited = new HashSet<>();
        while (!possible.isEmpty()) {
            int tryIndex = pickIndex(possible, visited, matchMap, len);
            int curMatches = master.guess(wordlist[tryIndex]);
            if (curMatches == wordlist[0].length()) return;
            for (int i = possible.size() - 1; i >= 0; i--) {
                if (matchMap[possible.get(i)][tryIndex] != curMatches)  {
                    possible.remove(i);
                }
            }
            visited.add(tryIndex);
        }
    }
    
    // Pick the index that has the minimum of the maximum of the number of distances that equal to one value
    // This picking approach can let the possbie size always decrease
    private int pickIndex(List<Integer> possible, Set<Integer> visited, int[][] matchMap, int len) {
        // If the possible words are less than two, just return one of them. We don't need to reduce it.
        if (possible.size() <= 2) return possible.get(0);
        
        List<Integer> resGroup = possible;
        int resMatches = -1;
        // Try each word
        for (int i = 0; i < matchMap.length; i++) {
            // Don't consider the visited words.
            if (visited.contains(i)) continue;
            
            // Split the match number from each word with current word to groups
            ArrayList<Integer>[] groups = new ArrayList[len + 1];
            for (int k = 0; k <= len; k++) {
                groups[k] = new ArrayList<>();    
            }
            for (Integer j : possible) {
                if (j != i) groups[matchMap[i][j]].add(j);
            }
            
            // Find the maximum group size of current word
            List<Integer> maxSizeGroup = groups[0];
            for (int k = 0; k <= len; k++) {
                if (groups[k].size() > maxSizeGroup.size()) {
                    maxSizeGroup = groups[k];
                }
            }
            
            // Update the minmax group size. We tend to choose the word in the next step that can make the possible size decrease most.
            if (maxSizeGroup.size() < resGroup.size()) {
                resGroup = maxSizeGroup;
                resMatches = i;
            }
        }
        return resMatches;
    }
}