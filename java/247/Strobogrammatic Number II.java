class Solution {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = init();
        List<String> res = new ArrayList<>();
        helper(res, n, 0, map, new StringBuilder());
        return res;
    }
    
    public void helper(List<String> res, int n, int cur, Map<Character, Character> map, StringBuilder sb)
    {
        if(cur == (n - 1) / 2 + 1)
        {
            if(n % 2 == 0)
            {
                sb.append(map.get(sb.charAt(cur - 1)));
            }
            else
            {
                if(sb.charAt(cur - 1) == '6' || sb.charAt(cur - 1) == '9')
                    return;
            }
            for(int i = cur - 2; i >= 0; i--)
            {
                sb.append(map.get(sb.charAt(i)));
            }
            res.add(sb.toString());
            sb.delete(cur, sb.length());
            return;
        }
        Iterator<Character> iter = map.keySet().iterator();
        while(iter.hasNext())
        {
            char temp = iter.next();
            if(cur == 0 && temp == '0' && n != 1) continue;
            sb.append(temp);
            helper(res, n, cur + 1, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }        
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