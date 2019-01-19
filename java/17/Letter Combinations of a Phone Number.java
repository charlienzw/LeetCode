class Solution {
    List<String> res;
    HashMap<Character,String> dict;

    public List<String> letterCombinations(String digits) {
        dict = new HashMap<>();
        dict.put('2',"abc");
        dict.put('3',"def");
        dict.put('4',"ghi");
        dict.put('5',"jkl");
        dict.put('6',"mno");
        dict.put('7',"pqrs");
        dict.put('8',"tuv");
        dict.put('9',"wxyz");
        res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        helper(digits, new StringBuilder());
        return res;
    }
    public void helper(String digits, StringBuilder sb)
    {
        if(sb.length() == digits.length())
        {
            res.add(sb.toString());
            return;
        }
        String s = dict.get(digits.charAt(sb.length()));
        for(int i = 0; i < s.length(); i++)
        {
            sb.append(s.charAt(i));
            helper(digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}