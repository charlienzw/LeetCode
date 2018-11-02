// Time: O(k^n)
// Space: O(k^n)
class Solution {
    Set<String> seen;
    StringBuilder res;
    public String crackSafe(int n, int k) {
       if(n == 1 && k == 1) return "0";
        seen = new HashSet<>();
        res = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - 1; i++)
        {
            sb.append("0");
        }
        String start = sb.toString();
        helper(start, k);
        res.append(start);
        return new String(res);       
    }
    public void helper(String pre, int k)
    {
        for(int i = 0; i < k; i++)
        {
            String newS = pre + i;
            if(!seen.contains(newS))
            {
                seen.add(newS);
                helper(newS.substring(1),k);
                res.append(i);
            }
        }
    }
}