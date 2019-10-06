class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            charCount.put(chars.charAt(i), charCount.getOrDefault(chars.charAt(i), 0) + 1);
        }
        
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (isGood(words[i], charCount)) {
                res += words[i].length();
            }
        }
        
        return res;
    }
    
    private boolean isGood(String str, Map<Character, Integer> charCount) {
        Map<Character, Integer> copyMap = new HashMap<>(charCount);
        for (int i = 0; i < str.length(); i++) {
            if (!copyMap.containsKey(str.charAt(i))) return false;
            copyMap.put(str.charAt(i), copyMap.get(str.charAt(i)) - 1);
            if (copyMap.get(str.charAt(i)) == 0) copyMap.remove(str.charAt(i));
        }
        return true;
    }
}