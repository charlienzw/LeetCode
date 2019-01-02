class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = init();
        for(int i = 0; i <= (num.length() - 1) / 2; i++)
        {
            if(!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(num.length() - 1 - i))
            {
                return false;
            }
        }
        return true;
    }
    
    public Map<Character, Character> init()
    {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        return map;
    }
}