class Solution {
    public boolean isSolvable(String[] words, String result) {
        Set<Character> nonZeroSet = new HashSet<>();
        Set<Character> charSet = new HashSet<>();
        List<Character> charList = new ArrayList<>();
        Map<Character, Integer> charCount = new HashMap<>();
        for (String word : words) {
            if (word.length() > 1) nonZeroSet.add(word.charAt(0));
            for (int i = 0; i < word.length(); i++) {
                charSet.add(word.charAt(i));
                charCount.put(word.charAt(i), charCount.getOrDefault(word.charAt(i), 0) + (int)Math.pow(10, word.length() - 1 - i));
            }
        }
        if (result.length() > 1) nonZeroSet.add(result.charAt(0));
        for (int i = 0; i < result.length(); i++) {
            charSet.add(result.charAt(i));
            charCount.put(result.charAt(i), charCount.getOrDefault(result.charAt(i), 0) - (int)Math.pow(10, result.length() - 1 - i));
        }
        for (Character c : charSet) charList.add(c);
        
        return dfs(charList, charCount, 0, 0, nonZeroSet, new HashSet<>());  
    }
    
    private boolean dfs(List<Character> charList, Map<Character, Integer> charCount, int cur, int diff, Set<Character> nonZeroSet, Set<Integer> visited) {
        if (cur == charList.size()) return diff == 0;
        for (int i = 0; i <= 9; i++) {
            if (!visited.contains(i)) {
                Character c = charList.get(cur);
                if (i == 0 && nonZeroSet.contains(c)) continue;
                visited.add(i);
                if (dfs(charList, charCount, cur + 1, diff + i * charCount.get(c), nonZeroSet, visited)) return true;
                visited.remove(i);
            }
        }
        return false;
    }
}