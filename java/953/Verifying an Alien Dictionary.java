/**
* Time: O(mn)
* Space: O(1)
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], index) > 0) return false;
        }
        return true;
    }
    
    private int compare(String word1, String word2, int[] index) {
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            if (index[word1.charAt(i) - 'a'] < index[word2.charAt(i) - 'a']) {
                return -1;
            } else if (index[word1.charAt(i) - 'a'] > index[word2.charAt(i) - 'a']) {
                return 1;
            } else {
                i++;
            }
        }
        if (i == word1.length() && i == word2.length()) return 0;
        return i == word1.length() ? -1 : 1;
    }
}