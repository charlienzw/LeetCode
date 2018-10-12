class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordDict.size();i++)
        {
            set.add(wordDict.get(i));
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(dp[j]&&set.contains(s.substring(j,i+1)))
                {
                    dp[i+1]=true;
                }
            }
        }
        return dp[s.length()];
    }
}