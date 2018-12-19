// Two pointer
// Time: O(n) Space: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int res=0;
        int i=0,j=0;
        while(i<s.length()&&j<s.length())
        {
            if(!set.contains((s.charAt(i))))
            {
                set.add(s.charAt(i));
                res=Math.max(res,set.size());
                i++;
            }
            else
            {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return res;
    }
}