class Solution {
    int res = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] cnt = new int[26];
        for (int i = 0; i < letters.length; i++) {
            cnt[letters[i] - 'a']++;
        }
        
        helper(words, 0, score, cnt, 0);
        return res;
    }
    
    private void helper(String[] words, int cur, int[] score, int[] cnt, int sumScore) {
        for (int j = 0; j < 26; j++) {
            if (cnt[j] < 0) return;
        }
        
        res = Math.max(res, sumScore);
        
        for (int i = cur; i < words.length; i++) {
            String word = words[i];
            
            int curScore = 0;
            int[] curCnt = new int[26];
            for (int j = 0; j < word.length(); j++) {
                curScore += score[word.charAt(j) - 'a'];
                curCnt[word.charAt(j) - 'a']++;
            }
            
            for (int j = 0; j < 26; j++) {
                cnt[j] -= curCnt[j];
            }
            
            helper(words, i + 1, score, cnt, sumScore + curScore);
            
            for (int j = 0; j < 26; j++) {
                cnt[j] += curCnt[j];
            }
        }
    }
}