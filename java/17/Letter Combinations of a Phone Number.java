class Solution {
    List<String> res;
    HashMap<Character,String> dict;

    public List<String> letterCombinations(String digits) {
        dict=new HashMap<>();
        dict.put('2',"abc");
        dict.put('3',"def");
        dict.put('4',"ghi");
        dict.put('5',"jkl");
        dict.put('6',"mno");
        dict.put('7',"pqrs");
        dict.put('8',"tuv");
        dict.put('9',"wxyz");
        res=new ArrayList<>();
        if(digits==null||digits.length()==0) return res;
        helper(digits,"",0);
        return res;
    }
    public void helper(String digits,String tmp,int cur)
    {
        if(cur==digits.length())
        {
            res.add(tmp);
            return;
        }
        String s=dict.get(digits.charAt(cur));
        for(int i=0;i<s.length();i++)
        {
            helper(digits,tmp+s.charAt(i),cur+1);
        }
    }
}