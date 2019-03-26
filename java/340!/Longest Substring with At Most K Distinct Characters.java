/*
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
slow = 0 fast = 0
    {e: 1}
slow = 0 fast = 1
    {e: 1, c: 1}
slow = 0 fast = 2
    {e: 2, c: 1}
slow = 0 fast = 3
    res = 3
    {e: 1, c: 1}
slow = 1 fast = 3
    res = 3
    {e: 1}
slow = 2 fast = 3
    {e: 1, b: 1}
slow = 2 fast = 4
    res = 2
    {b: 1}
slow = 3 fast = 4
    {b: 1, a: 1}
Time: O(n)
Space: O(K)
*/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0 || s.length() == 0) return 0;
        int res = 0;
        Map<Character, Integer> valueToCount = new HashMap<>();
        int slow = 0, fast = 0;
        while(fast < s.length()) {
            if(!valueToCount.containsKey(s.charAt(fast))) {
                while(valueToCount.keySet().size() == k) {
                    res = Math.max(res, fast - slow);
                    valueToCount.put(s.charAt(slow), valueToCount.get(s.charAt(slow)) - 1);
                    if(valueToCount.get(s.charAt(slow)) == 0) valueToCount.remove(s.charAt(slow));
                    slow++;
                }
                valueToCount.put(s.charAt(fast), 1);
            }
            else {
                valueToCount.put(s.charAt(fast), valueToCount.get(s.charAt(fast)) + 1);
            }
            fast++;
        }
        res = Math.max(res, fast - slow);
        return res;
    }
}