class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(!map.containsKey(s.charAt(i))) map.put(s.charAt(i), true);
            else map.put(s.charAt(i), false);
        }
        for(int i = 0; i < s.length(); i++)
        {
            if(map.get(s.charAt(i))) return i;
        }
        return -1;
    }
}