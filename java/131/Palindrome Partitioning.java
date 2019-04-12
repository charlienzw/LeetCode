class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, res, new ArrayList<>());
        return res;
    }
    
    public void helper(String curStr, List<List<String>> res, List<String> curList) {
        if(curStr.length() == 0) {
            res.add(new ArrayList<>(curList));
            return;
        }
        
        for(int i = 0; i < curStr.length(); i++) {
            String candidateStr = curStr.substring(0, i + 1);
            if(!isPalindrome(candidateStr)) continue;
            curList.add(curStr.substring(0, i + 1));
            helper(curStr.substring(i + 1), res, curList);
            curList.remove(curList.size() - 1);
        }
    }
    
    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}