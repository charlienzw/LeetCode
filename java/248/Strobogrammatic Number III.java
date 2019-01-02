class Solution {
    public int strobogrammaticInRange(String low, String high) {
        Map<Character, Character> map = init();
        int[] res = new int[]{0};
        for(int i = low.length(); i <= high.length(); i++)
        {
            helper(res, i, low, high, 0, map, new StringBuilder(), true, true);
        }
        return res[0];
    }
    
    public void helper(int[] res, int n, String low, String high, int cur, Map<Character, Character> map, StringBuilder sb, boolean lowflag, boolean highflag)
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
            res[0]++;
            sb.delete(cur, sb.length());
            return;
        }
        Iterator<Character> iter = map.keySet().iterator();
        while(iter.hasNext())
        {
            char temp = iter.next();
            if(cur == 0 && temp == '0' && n != 1) continue;
            if(n == low.length())
            {
                if(lowflag && temp < low.charAt(cur)) continue;
                lowflag = false;
                if(temp == low.charAt(cur)) lowflag = true;
            }
            if(n == high.length())
            {
                if(highflag && temp > high.charAt(cur)) continue;
                highflag = false;
                if(temp == high.charAt(cur)) highflag = true;
            }
            sb.append(temp);
            helper(res, n, low, high, cur + 1, map, sb, lowflag, highflag);
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