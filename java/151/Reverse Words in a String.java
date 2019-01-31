public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length() == 0) return "";
        s = reverse(s);
        int cur = 0;
        int pre = 0;
        StringBuilder res = new StringBuilder();
        while(cur < s.length()){
            if(s.charAt(cur) == ' '){
                res.append(reverse(s.substring(pre, cur)));
                res.append(" ");
                while(s.charAt(cur) == ' '){
                    cur++;
                }
                pre = cur;
            }
            cur++;
        }
        res.append(reverse(s.substring(pre, cur)));
        return res.toString();
    }
    
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}