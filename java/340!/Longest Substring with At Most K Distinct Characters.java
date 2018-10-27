//Time: O(n)
//Space: O(k)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0 || s.length() == 0) return 0;
        int res = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0, fast = 0;
        while(fast < s.length())
        {
            if(!map.containsKey(s.charAt(fast)))
            {
                if(map.size() == k)
                {
                    res = Math.max(res, fast - slow);
                    map.put(s.charAt(slow), map.get(s.charAt(slow)) - 1);
                    if(map.get(s.charAt(slow)) == 0)
                    {
                        map.remove(s.charAt(slow));
                    }
                    slow++;
                    continue;
                }
                map.put(s.charAt(fast), 1);
            }
            else
            {
                map.put(s.charAt(fast), map.get(s.charAt(fast)) + 1);
            }
            fast++;
        }
        res = Math.max(res, fast - slow);
        return res;
    }
}