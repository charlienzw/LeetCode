class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> char2Count = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char2Count.put(p.charAt(i), char2Count.getOrDefault(p.charAt(i), 0) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            char2Count.put(s.charAt(i), char2Count.getOrDefault(s.charAt(i), 0) - 1);
            if(char2Count.get(s.charAt(i)) == 0) {
                char2Count.remove(s.charAt(i));
            }
            if(i >= p.length()) {
                char2Count.put(s.charAt(i - p.length()), char2Count.getOrDefault(s.charAt(i - p.length()), 0) + 1);
                if(char2Count.get(s.charAt(i - p.length())) == 0) {
                    char2Count.remove(s.charAt(i - p.length()));
                }
            }
            if(char2Count.keySet().size() == 0) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}