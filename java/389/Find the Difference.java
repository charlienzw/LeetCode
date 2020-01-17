//Bit manipulation
class Solution {
    public char findTheDifference(String s, String t) {
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            c=c^(int)s.charAt(i);
        }
        for(int i=0;i<t.length();i++)
        {
            c=c^(int)t.charAt(i);
        }
        return (char)c;
    }
}
//Hashing
class Solution {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] < 0) return (char)('a' + i);
        }
        return 'a';
    }
}