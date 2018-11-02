// Time: O(n)
// Space: O(1)
class Solution {
    public String customSortString(String S, String T) {
        int[] map = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T.length(); i++)
        {
            map[T.charAt(i) - 'a']++;
        }
        for(int i = 0; i < S.length(); i++)
        {
            for(int j = 0; j < map[S.charAt(i) - 'a']; j++)
            {
                sb.append(S.charAt(i));
            }
            map[S.charAt(i) - 'a'] = 0;
        }
        for(char i = 'a'; i <= 'z'; i++)
        {
            if(map[i-'a'] > 0)
            {
                for(int j = 0; j < map[i-'a']; j++)
                {
                    sb.append(i);
                }
            }
        }
        return sb.toString();
    }
}