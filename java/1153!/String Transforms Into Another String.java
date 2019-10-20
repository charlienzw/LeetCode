class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        int n = str1.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), str2.charAt(i));
            } else if (map.get(str1.charAt(i)) != str2.charAt(i)) {
                return false;
            }
        }
        return new HashSet<>(map.values()).size() < 26;
    }
}